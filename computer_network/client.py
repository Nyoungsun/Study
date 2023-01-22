from socket import *

clientSocket = socket(AF_INET, SOCK_STREAM)  # TCP소켓을 만듬.
if not clientSocket.connect(('127.0.0.1', 12345)):  # IP : 127.0.0.1, PORT : 50000에 연결함.
    print('connect')
    while 1:  # 무한으로 루프를 돌면서 계산.
        message = input('enter expression(q to quit, 0 to initialize): ')  # 입력받아서
        if message == 'q' or message == 'Q':  # Q면 계산종료.
            break
        clientSocket.send(message.encode())
        print(clientSocket.recv(1024).decode())

