import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([[1,2,3,4,5,6,7,8,9,10], 
              [1,1,1,1,2,1.3,1.4,1.5,1.6,1.4],
              [9,8,7,6,5,4,3,2,1,0]]) 
y = np.array([2,4,6,8,10,12,14,16,18,20])

print(x.shape) #(3, 10)
print(y.shape) 

x = x.T
print(x.shape) #(10, 3)

model = Sequential()
model.add(Dense(6, input_dim = 3)) # input_dim = 열(column, feature)의 개수, input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(4))
model.add(Dense(4)) 
model.add(Dense(3)) 
model.add(Dense(2)) # hidden layer  
model.add(Dense(1)) # output layer

model.compile(loss = 'mae', optimizer = 'adam')
model.fit(x, y, epochs = 100, batch_size = 1) # 가중치와 바이어스가 생성됨


print('\n')
loss = model.evaluate(x, y) # loss 값 (실제값과 예측값의 오차) 반환 → 모델의 평가 기준 = loss(loss가 작을 수록 좋은 모델)
print('loss: ', loss)


print('\n')
result = model.predict([[10, 1.4, 0]]) 
print('예측값: ', result)