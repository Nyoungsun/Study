from tensorflow.keras.models import Sequential, Model
from tensorflow.keras.layers import Dense, Input, Dropout
from tensorflow.keras.callbacks import EarlyStopping
from sklearn.model_selection import train_test_split
from sklearn.datasets import load_digits
from tensorflow.keras.utils import to_categorical
from sklearn.metrics import accuracy_score
import numpy as np
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from sklearn.preprocessing import OneHotEncoder as OHE
import pandas as pd

#1. 데이터
datasets = load_digits()
# print(datasets)
# print(datasets.DESCR) # pandas: .describe() / .info()
# print(datasets.feature_names) # pandas: .columns

x = datasets.data
y = datasets['target']
# print("x: ", x ,"\ny:", y)
# print(x.shape, y.shape) # (1797, 64) (1797,) → 64 = 8x8 block
# print(np.unique(y, return_counts=True)) # 분류 데이터임을 알 수 있음 → (array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9]), array([178, 182, 177, 183, 181, 182, 181, 179, 174, 180]

# plt.gray()
# plt.matshow(datasets.images[9])
# plt.show()

y = to_categorical(y)
# print(y, y.shape)

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.8, random_state = 444, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로 
# print(y_train, "\n", y_test)

scaler = MMS()
# scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
model = Sequential()
model.add(Dense(8, input_shape = (64,)))
model.add(Dropout(0.3)) # 과적합 방지
model.add(Dense(16))
model.add(Dropout(0.2)) # 과적합 방지
model.add(Dense(16, activation='sigmoid'))
model.add(Dropout(0.1)) # 과적합 방지
model.add(Dense(10, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

# (functional)
# input = Input(shape=(64,))
# dense1 = Dense(8)(input)
# dense2 = Dense(16)(dense1)
# dense3 = Dense(16, activation='sigmoid')(dense2)
# output = Dense(10, activation='softmax')(dense3)
# model = Model(inputs = input, outputs = output)

#3. 컴파일, 훈련
model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics=['accuracy'])

earlyStopping = EarlyStopping(monitor='val_loss', mode = min, patience=16, restore_best_weights = True, verbose=3) 
model.fit(x_train, y_train, epochs = 1024, validation_split=0.2, verbose=3, callbacks = earlyStopping) 

#4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis = 1)
# print('y_predict: ', y_predict)

y_test = np.argmax(y_test, axis = 1)
# print('y_test: ', y_test)

acc = accuracy_score(y_test, y_predict)
print('accuracy: ', acc)

# MMS accuracy:  0.95
# SDS accuracy:  0.9416666666666667