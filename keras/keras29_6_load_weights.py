from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Model
from tensorflow.keras.layers import Dense, Input
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.callbacks import EarlyStopping 
import numpy as np

#1. 데이터
path = 'C:/study/keras_save/'

dataset = load_boston()         # 보스턴 집 값에 대한 데이터
x = dataset.data                # 방 넓이, 방 개수 등 → 독립변수
y = dataset.target              # 집 값 → 종속변수

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=3333)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성 
# (functional) Total params: 52,225
input = Input(shape=(13,))
dense1 = Dense(32)(input)
dense2 = Dense(64, activation= 'relu')(dense1)
dense3 = Dense(256, activation= 'relu')(dense2)
dense4 = Dense(128, activation= 'relu')(dense3)
output = Dense(1)(dense4)
model = Model(inputs=input, outputs=output)

# ------- 가중치 load ------- # 
# model.load_weights(path + 'keras29_5_save_weight1.h5') # model1에는 훈련되지 않은 가중치만 저장 (모델과 컴파일, 훈련 과정이 있어야함)
model.load_weights(path + 'keras29_5_save_weight2.h5') # model2에는 훈련된 가중치만 저장 (모델과 컴파일 과정이 있어야함, 훈련 과정 필요없음)

#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')

# earlyStopping = EarlyStopping(monitor='val_loss', mode='min', patience=16, restore_best_weights=True, verbose=3) # loss - min, accuracy - max 
# model.fit(x_train, y_train, epochs=256, batch_size=16, validation_split=0.2, callbacks = [earlyStopping], verbose=3) # verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
print('loss: ', loss) 

y_predict = model.predict(x_test)

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)
