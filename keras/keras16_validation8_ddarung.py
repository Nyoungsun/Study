from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import pandas as pd
import numpy as np
import time as t

#1. 데이터
path = './keras_data/ddarung/'
train_data = pd.read_csv(path + 'train.csv', index_col = 0)         # index_col = 0 → id 열 데이터로 취급 X
test_data = pd.read_csv(path + 'test.csv', index_col = 0)
submission = pd.read_csv(path + 'submission.csv', index_col = 0)

# print(train_data.shape)        # (1459, 10)
# print(test_data.shape)         # (715, 9)
# print(train_data.columns)      'hour', 'hour_bef_temperature', 'hour_bef_precipitation',
#                                'hour_bef_windspeed', 'hour_bef_humidity', 'hour_bef_visibility',
#                                'hour_bef_ozone', 'hour_bef_pm10', 'hour_bef_pm2.5', 'count'
# print(train_data.info())       # Missing Attribute Values: 결측치 - 데이터에 값이 없는 것
# print(train_data.describe())   # 평균, 표준편차, 최대값 등

# ---------------------- 결측치 처리 (대체) ------------------------ #
# print(train_data.isnull().sum())  
train_data =  train_data.fillna(train_data.mean())
# print(train_data.isnull().sum())

# ---------------------- x,y 분리 ------------------------ #
x = train_data.drop(['count'], axis=1)                              # y 값(count 열) 분리, axis = 1 → 열에 대해 동작
y = train_data['count']                                             # y 값(count 열)만 추출

x_train, x_test, y_train, y_test = train_test_split(
    x, y, train_size=0.7, random_state=44)

#2. 모델 구성
model = Sequential()
model.add(Dense(32, input_dim = 9))
model.add(Dense(128))
model.add(Dense(256, activation='relu'))
model.add(Dense(128))
model.add(Dense(16))
model.add(Dense(1))

#3. 컴파일 및 훈련
model.compile(loss='mse', optimizer='adam')
start = t.time()
model.fit(x_train, y_train, epochs = 100, batch_size = 1, validation_split=0.3)
fin = t.time()

#R2:  0.5964241800498333

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test) 
print('loss: ', loss)

y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)

def RMSE(y_test, y_predict):
    return np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE(y_test, y_predict))
r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

print("소요시간: ", fin - start)

# 제출
y_submit = model.predict(test_data)
submission['count'] = y_submit
submission.to_csv(path + 'submission_0106.csv')