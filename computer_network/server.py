import sys
from socket import *

serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('127.0.0.1', 12345))
serverSocket.listen(1)
print('waiting')

while 1:
    connSocket,addr = serverSocket.accept() #클라이언트가 들어오면
    print('connect\n')
    answer = 0
    while 1:
        data = connSocket.recv(1024).decode() #클라이언트에게서 받은 식 EX) 10 + 5또는 +6.
        if not data:
            break
        number = []
        message = ''
        if data[0] == '0' : #0이 들어오면 초기화하겠다는 것이므로 초기화.
            answer = 0 #이전 답 초기화.
            message = 'first'
            print('answer = 0')
        elif data[0] == '+' or data[0] == '-' or data[0] == '*' or data[0] == '/': #데이터의 첫번째가 연산자면 1+2같은게 아니라 이전 답에 이어서 연산하겠다는 뜻이므로
            op = data[0] #연산자에 따라서 계산함.
            if op == '+':
                message = 'answer : %d %s %d = %d' %(answer, op, int(data[1:]), answer + int(data[1:])) #int(data[1:])은 data[0]에는 연산자가 들어가있고, 그 뒤는 다 숫자라서 그냥 정수로 변환.
                answer = answer + int(data[1:]) #답에다가 연산. 나머지도 이와 같음.
            elif op == '-':
                message = 'answer : %d %s %d = %d' %(answer, op, int(data[1:]), answer - int(data[1:]))
                answer = answer - int(data[1:])
            elif op == '*':
                message = 'answer : %d %s %d = %d' %(answer, op, int(data[1:]), answer * int(data[1:]))
                answer = answer * int(data[1:])
            elif op == '/':
                message = 'answer : %d %s %d = %d' %(answer, op, int(data[1:]), answer/int(data[1:]))
                answer = answer / int(data[1:])
            print(message)
        else: #첫번째가 연산자가 아니면. ex) 1+2
            for i in range(0, len(data)): #입력받은 데이터 길이만큼 반복하면서
                if data[i] == '+' or data[i] == '-' or data[i] == '*' or data[i] == '/': #연산자가 나오면
                    op = data[i] #연산자를 저장하고
                    number.append(int(data[0:i])) #number리스트에 연산자 앞의 숫자를 변환해서 저장.
                    number.append(int(data[i+1:])) #연산자 뒤의 숫자를 변환해서 저장.
                    break
            if op == '+': #연산자에 따라서 분기함.
                message = 'answer : %d %s %d = %d' %(number[0], op, number[1], number[0] + number[1])
                answer = answer + number[0] + number[1]
            elif op == '-':
                message = 'answer : %d %s %d = %d' %(number[0], op, number[1], number[0] - number[1])
                answer = answer + number[0] - number[1]
            elif op == '*':
                message = 'answer : %d %s %d = %d' %(number[0], op, number[1], number[0] * number[1])
                answer = answer + number[0] * number[1]
            elif op == '/':
                message = 'answer : %d %s %d = %d' %(number[0], op, number[1], number[0] / number[1])
                answer = answer+number[0] / number[1]
            print(message)
        connSocket.send(message.encode()) #계산된 데이터를 클라이언트로 보냄.
