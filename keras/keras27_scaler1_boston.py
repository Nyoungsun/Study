from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.callbacks import EarlyStopping 
import numpy as np

#1. 데이터
dataset = load_boston()         
x = dataset.data                
y = dataset.target             

x_train, x_test, y_train, y_test = train_test_split(
    x, y, train_size=0.7, random_state=3333
)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
model = Sequential()
model.add(Dense(32, input_shape = (13,)))
model.add(Dense(64, activation='relu'))
model.add(Dense(256, activation='relu'))
model.add(Dense(128, activation='relu'))
model.add(Dense(1))


#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')

earlyStopping = EarlyStopping(monitor='val_loss', mode='min', patience=10, restore_best_weights=True, verbose=3) 
hist = model.fit(x_train, y_train, epochs=200, batch_size=10, validation_split=0.2, callbacks = [earlyStopping], verbose=3)

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)

# print(hist) # <keras.callbacks.History object at 0x000001ECB4986D00>
# print(hist.history) # 딕셔너리(key, value) → loss의 변화값을 list로(value는 list로 저장된다.)  
# print('val_loss: ', hist.history['val_loss']) # key = loss인 것만 출력

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)


# no scailing = R2:  0.6970241632402312
# MMS scailing = R2:  0.8189825577931096
# SDS scailing = R2:  0.8819064574259152
