import numpy as np
from tensorflow.keras.layers import Dense
from tensorflow.keras.models import Sequential
from sklearn.model_selection import train_test_split

#1. 데이터
x = np.array(range(1,17))
y = np.array(range(1,17))

# x_train = x[0:10]
# y_train = y[0:10]
# x_test = x[11:13]
# y_test = y[11:13]
# x_val = x[14:16]
# y_val = y[14:16]

x_train, x_tmp, y_train, y_tmp = train_test_split(
    x, y, train_size = 0.65, random_state = 1)

x_val, x_test, y_val, y_test = train_test_split(
    x_tmp, y_tmp, test_size = 0.5, random_state = 1)

print("학습 데이터: ", x_train.shape)
print("검증 데이터: ", x_val.shape)
print("테스트 데이터: ", x_test.shape)

#2. 모델 구성
model = Sequential()
model.add(Dense(5, input_dim = 1))
model.add(Dense(8, activation = 'relu'))
model.add(Dense(1))

#3. 컴파일 및 훈련
model.compile(loss='mae', optimizer='adam')
model.fit(x_train, y_train, epochs = 100, batch_size = 1, validation_data = (x_val, y_val))

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test)
print('evalution loss: ', loss)
result = model.predict([17])
print('17의 예측값: ', result)