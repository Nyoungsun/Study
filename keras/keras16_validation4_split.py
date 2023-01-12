import numpy as np
from tensorflow.keras.layers import Dense
from tensorflow.keras.models import Sequential
from sklearn.model_selection import train_test_split

#1. 데이터
x = np.array(range(1,17))
y = np.array(range(1,17))

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state = 1234)

print(x_train.shape, x_test.shape) # (12,) (4,)

#2. 모델 구성
model = Sequential()
model.add(Dense(5, input_dim = 1))
model.add(Dense(8, activation = 'relu')) 
model.add(Dense(1))

#3. 컴파일 및 훈련
model.compile(loss='mae', optimizer='adam')
model.fit(x_train, y_train, epochs = 100, batch_size = 1, validation_split = 0.25) # val_loss : 검증했을 때의 loss

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test)
print('evaluation loss: ', loss)

result = model.predict([17])
print('17의 예측값: ', result)