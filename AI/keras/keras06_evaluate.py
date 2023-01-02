import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([1,2,3,4,5,6])
y = np.array([1,2,3,5,4,6])

model = Sequential()
model.add(Dense(15, input_dim = 1)) # input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(10))
model.add(Dense(9)) 
model.add(Dense(6))
model.add(Dense(2)) # hidden layer  
model.add(Dense(1)) # output layer

model.compile(loss = 'mae', optimizer = 'adam')
model.fit(x, y, epochs = 100, batch_size = 6) # 가중치와 바이어스가 생성됨

#평가, 예측
loss = model.evaluate(x, y) # loss 값 (실제값과 예측값의 오차) 반환 → 모델의 평가 기준 = loss
print('loss: ', loss)
result = model.predict([6]) 
print('예측값: ', result)