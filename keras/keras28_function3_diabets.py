from sklearn.datasets import load_diabetes
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential, Model
from tensorflow.keras.layers import Dense, Input
from tensorflow.keras.callbacks import EarlyStopping
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
import numpy as np

#1. 데이터
dataset = load_diabetes()        
x = dataset.data                
y = dataset.target              

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=3333)

scaler = MMS()
# scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
# model = Sequential()
# model.add(Dense(32, activation='relu', input_shape = (10,)))
# model.add(Dense(16))
# model.add(Dense(16))
# model.add(Dense(8, activation='relu'))
# model.add(Dense(1))

# (functional)
input = Input(shape=(10,))
dense1 = Dense(8, activation= 'relu')(input)
dense2 = Dense(16, activation= 'relu')(dense1)
dense3 = Dense(8, activation= 'relu')(dense2)
dense4 = Dense(8, activation= 'relu')(dense3)
output = Dense(1, activation= 'relu')(dense4)
model = Model(inputs=input, outputs=output)
# model.summary()

#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')

earlyStopping = EarlyStopping(monitor='val_loss', mode = 'min', patience=8, restore_best_weights=True, verbose=3)
hist = model.fit(x_train, y_train, epochs=512, batch_size=2, validation_split=0.2, callbacks=[earlyStopping], verbose = 3) #verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지

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

# RMSE:  55.83781912698308
# R2:  0.4314180685476612