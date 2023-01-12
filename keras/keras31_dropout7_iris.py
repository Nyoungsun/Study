from tensorflow.keras.models import Sequential, Model
from tensorflow.keras.layers import Dense, Input, Dropout
from sklearn.model_selection import train_test_split
from sklearn.datasets import load_iris
from tensorflow.keras.utils import to_categorical
from sklearn.metrics import accuracy_score
import numpy as np
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from sklearn.preprocessing import OneHotEncoder as OHE
import pandas as pd

#1. 데이터
datasets = load_iris()
# print(datasets)
# print(datasets.DESCR) # pandas: .describe() / .info()
# print(datasets.feature_names) # pandas: .columns

x = datasets.data
y = datasets['target']
# print(x.shape, y.shape) # (150, 4), (150,)
# print(y) # 분류 데이터임을 알 수 있음

# y = pd.get_dummies(y) 또는 OneHotEncoder().fit(y.reshape(-1, 1)) y = OneHotEncoder().transform(y.reshape(-1, 1)).toarray()
y = to_categorical(y)
# print(y, y.shape)

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.8, random_state = 44, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로 
# print(y_train, "\n", y_test)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
model = Sequential()
model.add(Dense(64, activation='relu', input_shape = (4,)))
model.add(Dropout(0.3)) # 과적합 방지
model.add(Dense(32, activation='relu'))
model.add(Dropout(0.2)) # 과적합 방지
model.add(Dense(16, activation='sigmoid'))
model.add(Dropout(0.2)) # 과적합 방지
model.add(Dense(8, activation='sigmoid'))
model.add(Dense(3, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

# (functional)
# input = Input(shape=(4,))
# dense1 = Dense(64, activation='relu')(input)
# dense2 = Dense(32, activation='relu')(dense1)
# dense3 = Dense(16, activation= 'sigmoid')(dense2)
# dense4 = Dense(8, activation= 'sigmoid')(dense3)
# output = Dense(3, activation='softmax')(dense4)
# model = Model(inputs=input, outputs=output)
# model.summary()

#3. 컴파일, 훈련
model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics=['accuracy'])
model.fit(x_train, y_train, epochs = 32, batch_size=2, validation_split=0.2, verbose = 3)

#4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis = 1)
print('y_predict: ', y_predict)

y_test = np.argmax(y_test, axis = 1)
print('y_test: ', y_test)

acc = accuracy_score(y_test, y_predict) 
print('acc: ', acc)

# MMS acc:  1.0
# SDS acc:  1.0