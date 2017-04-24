#define _WINSOCK_DEPRECATED_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#pragma comment(lib,"ws2_32.lib")
#include <winsock2.h>
#include <stdio.h>
#include "stdlib.h"

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
	int size;
	char* data;
	int packet_size = 1024;
	char server_response_buffer[sizeof("ACK")];
	int server_response;

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

	while (1)
	{
		printf("STARTING DATA TRANSMISSION\n");
		int i = 0;
		while (packet_size*(i + 1) <= size) {
			sendto(sock, data + (i*packet_size), packet_size, NULL, (sockaddr*)&server, len);		// send all packets
			i++;
			printf("PACKET NUMBER %d SENT:\n", i);
			//printf("%s\n", data + (i * packet_size));
		}

		sendto(sock, data + (i*packet_size), size - (i*packet_size), NULL, (sockaddr*)&server, len);	// last packet
		printf("LAST PACKET NUMBER %d SENT:\n", (i+1));
		//printf("%s\n", data + (i * packet_size));

		server_response = recvfromTimeOutUDP(sock, 5, 0);		// check delay of server response

		switch (server_response) {
			case 0:
				printf("ACK TIMEOUT\n");
				printf("RETRYING TRANSMISSION\n");
				Sleep(1000);
				break;
			case -1:
				printf("ERROR NUMBER: %ld\n", WSAGetLastError());
				printf("RETRYING TRANSMISSION\n");
				Sleep(1000);
				break;
			default:
				recvfrom(sock, server_response_buffer, sizeof(server_response_buffer), 0, (sockaddr*)&server, &len);		// receive response from server
				printf("%s\n", server_response_buffer);
				if (strcmp(server_response_buffer, "ACK") == 0)
				{
					printf("ACK RECEIVED\n");
					free(data);
					printf("TRANSACTION COMPLETE\n");
					system("pause");
					break;
				}
				else
				{
					printf("INVALID RESPONSE FROM SERVER\n");
					printf("TO RETRY PRESS ANY KEY\n");
					system("pause");
					Sleep(1000);
				}
		}
	}

	closesocket(sock);
	return 0;
}