from tensorflow.keras.models import Sequential 
from tensorflow.keras.layers import Dense
from tensorflow.keras.callbacks import EarlyStopping
from sklearn.model_selection import train_test_split
from sklearn.datasets import fetch_covtype
from sklearn.metrics import accuracy_score
import tensorflow as tf
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


x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.8, random_state = 444, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로 
# print(y_train, "\n", y_test)

#2. 모델구성
model = Sequential()
model.add(Dense(16, input_shape=(54,)))
model.add(Dense(32))
model.add(Dense(16, activation='sigmoid'))
model.add(Dense(16, activation='sigmoid'))
model.add(Dense(7, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

#3. 컴파일, 훈련
model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics=['accuracy'])

earlyStopping = EarlyStopping(monitor = 'val_loss', mode = min, patience = 16, restore_best_weights = True, verbose=3) 
model.fit(x_train, y_train, epochs = 1024, validation_split = 0.2, batch_size = 4096, callbacks=earlyStopping, verbose=3)

#4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis = 1) # numpy.ndarray로 변환하지않으면 tensorflow의 argmax를 사용하면됨 
print('y_predict: ', y_predict[:10])

y_test = np.argmax(y_test, axis = 1)
print('y_test: ', y_test[:10])

acc = accuracy_score(y_test, y_predict)
print('accuracy: ', acc)