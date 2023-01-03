import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([1,2,3,4,5,6,7,8,9,10]) 
y = np.array(range(10))

x_train = x[:7] # 1,2,3,4,5,6,7
x_test = x[7:] # 8,9,10

y_train = y[:7] # 0,1,2,3,4,5,6
y_test = y[7:] # 7,8,9

model = Sequential()
model.add(Dense(10, input_dim = 1))
model.add(Dense(30))
model.add(Dense(20))
model.add(Dense(10))
model.add(Dense(1))

model.compile(loss='mae', optimizer = 'adam')
model.fit(x_train, y_train, epochs=200, batch_size=1) # 훈련 데이터로만 훈련해야함

print('\n')
loss = model.evaluate(x_test, y_test) # 평가 데이터로만 평가해야함
print('loss: ', loss)

print('\n')
result = model.predict([11])
print('[11]의 결과: ', result)