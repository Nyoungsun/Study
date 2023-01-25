from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.models import Sequential, Model
from tensorflow.keras.layers import Dense, Input, Dropout
from tensorflow.keras.callbacks import EarlyStopping
import numpy as np
import pandas as pd

#1. 데이터
path = 'C:/study/keras/keras_data/ddarung/'
# path = 'C:/study/keras_data/ddarung/'

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

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=44)

scaler = MMS()
# scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
model = Sequential()
model.add(Dense(64, input_shape = (9,)))
model.add(Dropout(0.2)) # 과적합 방지
model.add(Dense(128, activation='relu'))
model.add(Dropout(0.3)) # 과적합 방지
model.add(Dense(512, activation='relu'))
model.add(Dropout(0.5)) # 과적합 방지
model.add(Dense(128, activation='relu'))
model.add(Dense(1))

# (functional)
# input = Input(shape=(9,))
# dense1 = Dense(32)(input)
# dense2 = Dense(64, activation= 'relu')(dense1)
# dense3 = Dense(256, activation= 'relu')(dense2)
# dense4 = Dense(128, activation= 'relu')(dense3)
# output = Dense(1)(dense4)
# model = Model(inputs=input, outputs=output)

#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')

earlyStopping = EarlyStopping(monitor='val_loss', mode=min, patience = 16, restore_best_weights=True, verbose = 3)
hist = model.fit(x_train, y_train, epochs=1024, batch_size=32, validation_split=0.2, callbacks = [earlyStopping], verbose = 3) #verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)

# print(hist) # <keras.callbacks.History object at 0x000001ECB4986D00>
# print(hist.history) # 딕셔너리(key, value) → loss의 변화값을 list로(value는 list로 저장된다.)  
# print(hist.history['loss']) # key = loss인 것만 출력

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

y_submit = model.predict(scaler.transform(test_data))
submission['count'] = y_submit
submission.to_csv(path + 'submission_0115.csv')

# MMS
# RMSE:  46.994101216643735
# R2:  0.6749077541187736'

# SDS
# RMSE:  47.41885980219907
# R2:  0.6690044698182109