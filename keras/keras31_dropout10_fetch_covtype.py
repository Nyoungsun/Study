from tensorflow.keras.models import Sequential, Model
from tensorflow.keras.layers import Dense, Input, Dropout
from tensorflow.keras.callbacks import EarlyStopping
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from sklearn.datasets import fetch_covtype
from sklearn.metrics import accuracy_score
import numpy as np
import pandas as pd

#1. 데이터
datasets = fetch_covtype()
# print(datasets)
# print(datasets.DESCR) # pandas: .describe() / .info()
# print(datasets.feature_names) # pandas: .columns

x = datasets.data
y = datasets.target
# print("x: ", x ,"\ny:", y)
# print(x.shape, y.shape) # (581012, 54) (581012,)
# print(np.unique(y, return_counts=True)) # array([1, 2, 3, 4, 5, 6, 7]), array([211840, 283301,  35754,   2747,   9493,  17367,  20510])

y = pd.get_dummies(y)
# print(type(y), y.shape)   # <class 'pandas.core.frame.DataFrame'>, (581012, 7)
# print(y[:10])             # index와 header가 자동 생성됨
y = y.to_numpy()            # y = y.values → numpy.ndarray 변환
# print(type(y), (y[:10]))  # <class 'numpy.ndarray'>


x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.8, random_state = 128, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로 
# print(y_train, "\n", y_test)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
model = Sequential()
model.add(Dense(16, input_shape=(54,)))
model.add(Dropout(0.2)) # 과적합 방지
model.add(Dense(32))
model.add(Dropout(0.3)) # 과적합 방지
model.add(Dense(16, activation='sigmoid'))
model.add(Dropout(0.1)) # 과적합 방지
model.add(Dense(16, activation='sigmoid'))
model.add(Dense(7, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

# (functional)
# input = Input(shape = (54,))
# dense1 = Dense(16)(input)
# dense2 = Dense(32)(dense1)
# dense3 = Dense(16, activation='sigmoid')(dense2)
# dense4 = Dense(16, activation='sigmoid')(dense3)
# output = Dense(7, activation = 'softmax')(dense4)
# model = Model(inputs = input, outputs = output)

#3. 컴파일, 훈련
model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics=['accuracy'])

earlyStopping = EarlyStopping(monitor = 'val_loss', mode = min, patience = 4, restore_best_weights = True, verbose=3) 
model.fit(x_train, y_train, epochs = 512, validation_split = 0.2, batch_size = 131072, callbacks=earlyStopping, verbose=1)

#4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis = 1) # numpy.ndarray로 변환하지않으면 tensorflow의 argmax를 사용하면됨 
print('y_predict: ', y_predict[:10])

y_test = np.argmax(y_test, axis = 1)
print('y_test: ', y_test[:10])

acc = accuracy_score(y_test, y_predict)
print('accuracy: ', acc)

# MMS accuracy:  0.7288107880175211
# SDS accuracy:  0.7524074249373941