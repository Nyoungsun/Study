from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import load_model
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.callbacks import EarlyStopping 
import numpy as np

#1. 데이터
path = 'C:/study/keras_save/'

dataset = load_boston()         
x = dataset.data                
y = dataset.target              

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=3333)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성 
model = load_model(path + 'keras29_1_save_model.h5').summary() # 가중치 없이 모델만 저장되어있으므로 컴파일 및 훈련을 수행해야함

#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')

earlyStopping = EarlyStopping(monitor='val_loss', mode='min', patience=16, restore_best_weights=True, verbose=3)  
hist = model.fit(x_train, y_train, epochs=256, batch_size=16, validation_split=0.2, callbacks = [earlyStopping], verbose=3) 

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model.predict(x_test)

print('val_loss: ', hist.history['val_loss']) 

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)
