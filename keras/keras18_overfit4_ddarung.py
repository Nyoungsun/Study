from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

#1. 데이터
path = './keras_data/ddarung/'
train_data = pd.read_csv(path + 'train.csv', index_col = 0) # index_col = 0 → id 열 데이터로 취급 X
test_data = pd.read_csv(path + 'test.csv', index_col = 0)
submission = pd.read_csv(path + 'submission.csv', index_col = 0)

# ---------------------- 결측치 처리 (제거)----------------------- #
train_data = train_data.dropna()

# ---------------------- x,y 분리 ------------------------ #
x = train_data.drop(['count'], axis=1)  # y 값(count 열) 분리, axis = 1 → 열에 대해 동작
y = train_data['count']                 # y 값(count 열)만 추출

# print(train_data.shape)        # (1459, 10)
# print(test_data.shape)         # (715, 9)
# print(train_data.columns)      'hour', 'hour_bef_temperature', 'hour_bef_precipitation',
#                               'hour_bef_windspeed', 'hour_bef_humidity', 'hour_bef_visibility',
#                               'hour_bef_ozone', 'hour_bef_pm10', 'hour_bef_pm2.5', 'count'
# print(train_data.info())       # Missing Attribute Values: 결측치 - 데이터에 값이 없는 것
# print(train_data.describe())   # 평균, 표준편차, 최대값 등

x_train, x_test, y_train, y_test = train_test_split(
    x,y,
    train_size=0.7,
    random_state=44
)


x_train, x_test, y_train, y_test = train_test_split(
    x, y, train_size=0.7, random_state=3333
)

#2. 모델구성
model = Sequential()
model.add(Dense(32, input_shape = (9,)))
model.add(Dense(64))
model.add(Dense(256))
model.add(Dense(512))
model.add(Dense(128))
model.add(Dense(1))


#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')
hist = model.fit(x_train, y_train, epochs=100, batch_size=1, validation_split=0.2, verbose = 3) #verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)
print('loss: ', loss)

# print(hist) # <keras.callbacks.History object at 0x000001ECB4986D00>
# print(hist.history) # 딕셔너리(key, value) → loss의 변화값을 list로(value는 list로 저장된다.)  
# print(hist.history['loss']) # key = loss인 것만 출력

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)
r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

plt.figure(figsize=(9,6))
plt.plot(hist.history['loss'], c='red', marker='.', label = 'loss')
plt.plot(hist.history['val_loss'], c='blue', marker='.', label = 'val_loss')
plt.grid() 
plt.xlabel('epochs')
plt.ylabel('loss')
plt.legend() # label 출력 # plt.legend(loc = 'upper left')
plt.title("ddarung loss")
plt.show()

#R2 = 0.74