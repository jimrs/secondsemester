#define _WINSOCK_DEPRECATED_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#pragma comment(lib,"ws2_32.lib")
#include <winsock2.h>
#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
#include <stdint.h>
#include <string.h>
#include "md5.h"

/* CRC-32C (iSCSI) polynomial in reversed bit order. */
#define POLY 0x82f63b78

/* CRC-32 (Ethernet, ZIP, etc.) polynomial in reversed bit order. */
/* #define POLY 0xedb88320 */

uint32_t crc32c(uint32_t crc, const char *buf, size_t len)		// pri volani psat vzdy prvni argument 0
{
	int k;

	crc = ~crc;			// bitwise negation
	while (len--) {
		crc ^= *buf++;
		for (k = 0; k < 8; k++)
			crc = crc & 1 ? (crc >> 1) ^ POLY : crc >> 1;
	}
	return ~crc;
}

void InitWinsock()
{
	WSADATA wsaData;
	WSAStartup(MAKEWORD(2, 2), &wsaData);
}

int recvfromTimeOutUDP(SOCKET socket, long sec, long usec)
{
	// Setup timeval variable
	struct timeval timeout;
	struct fd_set fds;

	timeout.tv_sec = sec;
	timeout.tv_usec = usec;
	// Setup fd_set structure
	FD_ZERO(&fds);
	FD_SET(socket, &fds);
	// Return value:
	// -1: error occurred
	// 0: timed out
	// > 0: data ready to be read
	return select(0, &fds, 0, 0, &timeout);
}

int main()
{
	SOCKET sock;
	FILE* file;
	MD5 md5;
	char* file_md5;
	int size;
	char* data;
	int packet_size = 1024;
	char server_response_buffer[sizeof("ACK")];
	int server_response;
	char server_response_hash[sizeof("HASHOK")];

	InitWinsock();
	struct sockaddr_in server;
	int len = sizeof(server);
	server.sin_family = AF_INET;
	server.sin_port = htons(8888);							// port to communicate on
	server.sin_addr.s_addr = inet_addr("127.0.0.1");	// server IP address

	sock = socket(AF_INET, SOCK_DGRAM, 0);					// initialize socket
	printf("SOCKET INITIALIZED\n");

	data = (char*)malloc(100000);		// malloc for filesize to transmit
	file = fopen("send.jpg", "rb");
	if (file) {
		for (size = 0; fread(data + size, 1, 1, file) == 1; size++);
	}
	printf("FILE LOADED\n");
	printf("FILE SIZE TO BE SENT: %d\n", size);

	sendto(sock, (char*)&size, 4, NULL, (sockaddr*)&server, len);		// send info about size

	file_md5 = md5.digestFile("send.jpg");
	sendto(sock, file_md5, 32, NULL, (sockaddr*)&server, len);
	printf("MD5 SENT: \n%s\n", file_md5);

	while (1)
	{
		printf("STARTING DATA TRANSMISSION\n");
		int i = 0;
		while (packet_size*(i + 1) <= size) {
			sendto(sock, data + (i*packet_size), packet_size, NULL, (sockaddr*)&server, len);		// send all packets
			printf("PACKET NUMBER %d SENT: ", (i + 1));
			server_response = recvfromTimeOutUDP(sock, 5, 0);		// check delay of server response
			switch (server_response) {
			case 0:
				printf("ACK TIMEOUT\n");
				printf("RESENDING PACKET\n");
				Sleep(100);
				break;
			default:
				recvfrom(sock, server_response_buffer, sizeof(server_response_buffer), 0, (sockaddr*)&server, &len);
				if (strcmp(server_response_buffer, "ACK") == 0) {
					printf("OK\n");
					i++;
				}
				else {
					printf("BAD\n");
				}
			}
		}

		sendto(sock, data + (i*packet_size), size - (i*packet_size), NULL, (sockaddr*)&server, len);	// last packet
		printf("LAST PACKET NUMBER %d SENT:\n", (i + 1));

		recvfrom(sock, server_response_hash, sizeof(server_response_hash), 0, (sockaddr*)&server, &len);
		if (strcmp(server_response_hash, "HASHOK") == 0) {
			printf("SERVER REPORTED MD5 CHECK OK\n");
			free(data);
			fcloseall();
			printf("TRANSACTION COMPLETE\n");
			system("pause");
			break;
		}
		else {
			printf("SERVER REPORTED MD5 CHECK BAD OR INVALID RESPONSE\n");
			printf("RETRYING TRANSMISSION\n");
			Sleep(1000);
		}
	}

	closesocket(sock);
	return 0;
}