from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential, load_model, Model
from tensorflow.keras.layers import Dense, Input
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.callbacks import EarlyStopping, ModelCheckpoint
import numpy as np

#1. 데이터
path = 'C:/study/keras_save/MCP/'

dataset = load_boston()         
x = dataset.data               
y = dataset.target              

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=3333)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성 
input = Input(shape=(13,))
dense1 = Dense(32)(input)
dense2 = Dense(64, activation= 'relu')(dense1)
dense3 = Dense(256, activation= 'relu')(dense2)
dense4 = Dense(128, activation= 'relu')(dense3)
output = Dense(1)(dense4)
model = Model(inputs=input, outputs=output)

#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')

ES = EarlyStopping(monitor='val_loss', mode='min', patience=16, verbose = 1, restore_best_weights=True) 
# restore_best_weights=False: default → EarlyStopping된 지점에서부터 patience만큼(가중치가 가장 좋은 지점 X)
MCP = ModelCheckpoint(monitor='val_loss', mode = 'auto', save_best_only=True, verbose = 1, filepath = path + 'keras30_ModelCheckPoint1.hdf5') 
# ModelCheckpoint: 모델과 가중치 저장, save_best_only=True: 가장 좋은 가중치 저장
model.fit(x_train, y_train, epochs=1024, batch_size=16, validation_split=0.2, callbacks=[ES, MCP]) 

# ----------------- 모델, 가중치 저장 ----------------- #
model.save(path + 'keras30_ModelCheckPoint3_model.h5') 
# hdf5 = h5

#4. 평가 및 예측
print('========================= 1. 기본 출력 ===========================')
loss = model.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model.predict(x_test, verbose=3)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

print('========= 2. load_model 출력(model.save로 저장된 모델) ============')
model2 = load_model(path + 'keras30_ModelCheckPoint3_model.h5')

loss = model2.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model2.predict(x_test, verbose=3)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

print('===== 3. ModelCheckPoint 출력(ModelCheckPoint로 저장된 모델) ======')
model3 = load_model(path + 'keras30_ModelCheckPoint1.hdf5')

loss = model3.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model3.predict(x_test, verbose=3)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)


# R2:  0.8778605196555671
