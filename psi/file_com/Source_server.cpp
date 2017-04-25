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

int main()
{
	SOCKET sock;
	FILE* file;
	MD5 md5;
	char* file_md5_start = (char*)malloc(32);
	char* file_md5_end;
	int size;
	char* data;
	int packet_size = 1024;

	InitWinsock();
	struct sockaddr_in local;
	struct sockaddr_in from;
	int fromlen = sizeof(from);
	local.sin_family = AF_INET;
	local.sin_port = htons(8888);					// port to communicate on
	local.sin_addr.s_addr = INADDR_ANY;				// accept connection from any IP address

	sock = socket(AF_INET, SOCK_DGRAM, 0);			// initialize socket
	bind(sock, (sockaddr*)&local, sizeof(local));	// bind socket on any IP address
	printf("SOCKET INITIALIZED\n");

	printf("WAITING FOR FIRST MESSAGE\n");
	recvfrom(sock, (char*)&size, 4, NULL, (sockaddr*)&from, &fromlen);		// waiting for first message, contains size of data
	printf("RECEIVED INFO ABOUT SIZE\n");
	printf("SIZE OF DATA TO BE TRANSMITTED: %d\n", size);

	recvfrom(sock, file_md5_start, 32, NULL, (sockaddr*)&from, &fromlen);	// receiving md5 hash
	printf("RECEIVED MD5\n");
	printf("FILE MD5 IS: \n%s\n", file_md5_start);

	while (1)
	{
		printf("STARTING DATA TRANSMISSION\n");
		data = (char*)malloc(size);		// data buffer allocation
		int i = 0;
		while (packet_size * (i + 1) <= size) {
			recvfrom(sock, data+(i*packet_size), packet_size, NULL, (sockaddr*)&from, &fromlen);
			printf("PACKET NUMBER %d RECEIVED: ", (i + 1));
			if (1) {
				sendto(sock, "ACK", sizeof("ACK"), 0, (sockaddr*)&from, fromlen);
				printf("OK\n");
				i++;
			}
			else {
				printf("BAD\n");
			}	
		}

		recvfrom(sock, data + (i * packet_size), size - (i * packet_size), NULL, (sockaddr*)&from, &fromlen);		// last packet receive 
		printf("LAST PACKET NUMBER %d RECEIVED:\n", (i+1));

		file = fopen("recv.jpg", "wb");		
		fwrite(data, 1, size, file);		// write data buffer to file
		printf("FILE RECEIVED AND SAVED\n");
		free(data);							// free data buffer
		fcloseall();						// important!!!

		file_md5_end = md5.digestFile("recv.jpg");													// start of md5check
		printf("RECEIVED AND SAVED HASH:\n%s\n%s\n", file_md5_start, file_md5_end);

		if (file_md5_start == file_md5_end) {
			sendto(sock, "HASHOK", sizeof("HASHOK"), 0, (sockaddr*)&from, fromlen);
			printf("MD5 CHECK OK\n");
			printf("TRANSACTION COMPLETE\n");
			system("pause");
			break;
		}
		else {
			sendto(sock, "HASHNO", sizeof("HASHNO"), 0, (sockaddr*)&from, fromlen);
			printf("WRONG MD5 CHECK\n");
			printf("RETRYING TRANSACTION\n");
		}
	}

	closesocket(sock);
	return 0;
}