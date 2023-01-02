import tensorflow as tf
import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([1,2,3,4,5])
y = np.array([1,2,3,4,5])

model = Sequential()
model.add(Dense(10, input_dim = 1)) # input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(8)) 
model.add(Dense(6))
model.add(Dense(2)) # hidden layer
model.add(Dense(1)) # output layer

model.compile(loss = 'mae', optimizer = 'Adam')
model.fit(x, y, epochs = 200)

result = model.predict([6])
print('예측값: ', result)