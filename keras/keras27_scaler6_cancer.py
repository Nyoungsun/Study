from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.callbacks import EarlyStopping
import numpy as np 

#1. 데이터
dataset = load_breast_cancer()        

# print(dataset)
# print(dataset.DESCR)
# print(dataset.feature_names)

x = dataset['data']  # x = dataset.data               
y = dataset['target']      

# print(x.shape, y.shape) # (569, 30), (569,)

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=3333)

scaler = MMS()
# scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
model = Sequential()
model.add(Dense(32, input_shape = (30,)))
model.add(Dense(16))
model.add(Dense(16, activation='relu'))
model.add(Dense(8, activation='relu'))
model.add(Dense(1, activation='sigmoid')) # sigmoid: 0~1 사이의 값으로 → 이진 분류에서 사용, 보통 출력 층에서 사용

#3. 컴파일 및 훈련
model.compile(loss = 'binary_crossentropy', optimizer='adam', metrics=['accuracy']) # 이진분류 loss = binary_crossentropy

earlyStopping = EarlyStopping(monitor='val_loss', mode='min', patience=20, restore_best_weights=True) 
# earlyStopping = EarlyStopping(monitor='accuracy', mode='max', patience=20, restore_best_weights=True) 
hist = model.fit(x_train, y_train, epochs=1024, batch_size=16, validation_split=0.2, callbacks = [earlyStopping], verbose = 3) 

#4. 평가 및 예측
loss, accuracy = model.evaluate(x_test, y_test)
print('loss: ', loss, 'accuracy: ', accuracy)

y_predict = np.where(model.predict(x_test) > 0.5, 1, 0)
# y_predict = y_predict.round() 또는 y_predict = np.asarray(y_predict, dtype=int) 
y_predict = y_predict.flatten()
print('y_predict: ', y_predict[:10], '\ny_test: ', y_test[:10])

acc = accuracy_score(y_test, y_predict) 
print('acc: ', acc)

# print(hist.history['val_loss']) # metrics를 넣으면 history에 metrics에 대한 수치도 나온다.
# print(hist.history['accuracy'])

# no scailing acc:  0.935672514619883
# MMS acc:  0.9766081871345029
# SDS acc:  0.9707602339181286