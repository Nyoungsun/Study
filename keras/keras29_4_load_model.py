from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import load_model
from tensorflow.keras.layers import Dense, Input
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

#2. 모델구성 및 컴파일, 훈련
model = load_model(path + 'keras29_3_save_model.h5') # 모델과 가중치까지 저장되어있기 때문에 컴파일, 훈련을 따로 수행하지 않아도 되며, 결과치도 항상 동일함

#3. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss)

y_predict = model.predict(x_test)

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)
