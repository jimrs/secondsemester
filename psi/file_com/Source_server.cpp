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

int main()
{
	SOCKET sock;
	FILE* file;
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

	while (1)
	{
		printf("STARTING DATA TRANSMISSION\n");
		data = (char*)malloc(size);		// data buffer allocation
		int i = 0;
		while (packet_size * (i + 1) <= size) {
			recvfrom(sock, data+(i*packet_size), packet_size, NULL, (sockaddr*)&from, &fromlen);
			i++;
			printf("PACKET NUMBER %d RECEIVED\n", i);
		}

		recvfrom(sock, data + (i * packet_size), size - (i * packet_size), NULL, (sockaddr*)&from, &fromlen);		// last packet receive 
		printf("LAST PACKET NUMBER %d RECEIVED:\n", (i+1));
		//printf("%s\n", data + (i * packet_size));

		sendto(sock, "ACK", sizeof("ACK"), 0, (sockaddr*)&from, fromlen);		// confirm response
		printf("ACK SENT\n");

		file = fopen("recv.jpg", "wb");		
		fwrite(data, 1, size, file);		// write data buffer to file
		printf("FILE RECEIVED AND SAVED\n");

		free(data);							// free data buffer

		printf("TRANSACTION COMPLETE\n");
		system("pause");
		break;
	}

	closesocket(sock);
	return 0;
}