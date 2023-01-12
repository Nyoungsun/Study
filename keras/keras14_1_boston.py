from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import numpy as np

#1. 데이터
dataset = load_boston()         # 보스턴 집 값에 대한 데이터
x = dataset.data                # 방 넓이, 방 개수 등 → 독립변수
y = dataset.target              # 집 값 → 종속변수

# print(x)
# print(x.shape)                  # (506, 13)
# print(y)
# print(y.shape)                  # (506,)
# print(dataset.feature_names)    # ['CRIM' 'ZN' 'INDUS' 'CHAS' 'NOX' 'RM' 'AGE' 'DIS' 'RAD' 'TAX' 'PTRATIO' 'B' 'LSTAT']
# print(dataset.DESCR)            # Missing Attribute Values: 결측치 - 데이터에 값이 없는 것

#2. 모델구성
x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=44)

model = Sequential()
model.add(Dense(32, input_dim = 13))
model.add(Dense(64))
model.add(Dense(256))
model.add(Dense(512))
model.add(Dense(128))
model.add(Dense(1))

#3. 컴파일 및 훈련
model.compile(loss='mae', optimizer='adam', metrics  = ['mse'])
model.fit(x_train, y_train, epochs = 200, batch_size = 1)

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test) 
print('loss: ', loss)

y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE(y_test, y_predict))

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

#R2 = 0.72 