import numpy as np
from tensorflow.keras.layers import Dense
from tensorflow.keras.models import Sequential

#1. 데이터
x_train = np.array(range(1,11))
y_train = np.array(range(1,11))
x_test = np.array([11,12,13])
y_test = np.array([11,12,13])
x_validation = np.array([14,15,16])
y_validation = np.array([14,15,16])

#2. 모델 구성
model = Sequential()
model.add(Dense(5, input_dim =1))
model.add(Dense(8, activation = 'relu'))
model.add(Dense(1))

#3. 컴파일 및 훈련
model.compile(loss='mae', optimizer='adam')
model.fit(x_train, y_train, epochs = 100, batch_size = 1, validation_data = (x_validation, y_validation))

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test)
print('evaluation loss: ', loss)
result = model.predict([17])
print('17의 예측값: ', result)