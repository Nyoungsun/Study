import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([1,2,3,4,5])
y = np.array([1,2,3,5,4])

model = Sequential()
model.add(Dense(15, input_dim = 1)) # input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(10)) 
model.add(Dense(9))
model.add(Dense(8))
model.add(Dense(5)) # hidden layer
model.add(Dense(1)) # output layer

model.compile(loss = 'mae', optimizer = 'adam')
model.fit(x, y, epochs = 300)

result = model.predict([6])
print('예측값: ', result)