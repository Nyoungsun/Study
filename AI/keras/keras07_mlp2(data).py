import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([[1,2,3,4,5,6,7,8,9,10], 
              [1,1,1,1,2,1.3,1.4,1.5,1.6,1.4],
              [93,1,12,34,432,13,24,15,33,11],
              [933,23,1,3,92,43,27,1432,321,41],
              [3,23,43,65,67,19,84,75,53,31],
              [73,423,111,39,20,143,24,65,43,15],
              [93,4,15,44,42,13,2321,1,3,0]]) 
y = np.array([2,4,6,8,10,12,14,16,18,20])

print(x.shape) 

x = x.T
print(x.shape) 

model = Sequential()
model.add(Dense(150, input_dim = 7)) # input_dim = 열(column, feature)의 개수, input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(90))
model.add(Dense(80)) 
model.add(Dense(50)) 
model.add(Dense(20)) # hidden layer  
model.add(Dense(1)) # output layer

model.compile(loss = 'mae', optimizer = 'adam')
model.fit(x, y, epochs = 2000, batch_size = 5) # 가중치와 바이어스가 생성됨


print('\n')
loss = model.evaluate(x, y) # loss 값 (실제값과 예측값의 오차) 반환 → 모델의 평가 기준 = loss(loss가 작을 수록 좋은 모델)
print('loss: ', loss)


print('\n')
result = model.predict([[10, 1.4, 11, 41, 31, 15, 0]]) 
print('예측값: ', result)