from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.callbacks import EarlyStopping
from sklearn.model_selection import train_test_split
from sklearn.datasets import fetch_covtype
from sklearn.metrics import accuracy_score
from sklearn.preprocessing import OneHotEncoder as ohe
import pandas as pd
import numpy as np

# 1. 데이터
datasets = fetch_covtype()
# print(datasets)
# print(datasets.DESCR) # pandas: .describe() / .info()
# print(datasets.feature_names) # pandas: .columns

x = datasets.data
y = datasets.target
# print("x: ", x ,"\ny:", y)
# print(x.shape, y.shape) # (581012, 54) (581012,)
# print(np.unique(y, return_counts=True)) # array([1, 2, 3, 4, 5, 6, 7]), array([211840, 283301,  35754,   2747,   9493,  17367,  20510]

# print("원래 y: ", y[:10])
y = ohe(sparse=False).fit_transform(y.reshape(-1,1)) # 2차원으로 변환하여 one-hot encoding 수행, sparse = False: array 반환 (one-hot encoding에 필요한 것은 array이므로) 
                                                     # reshape의 행(-1): 열의 값은 특정 정수로 지정이 되어있을 때, 남은 배열의 길이와 남은 차원으로부터 추정해서 알아서 지정하라는 의미                         
# print(type(y), y.shape) # sparse = True일 때: <class 'scipy.sparse._csr.csr_matrix'>, sparse = False일 때: <class 'numpy.ndarray'>, (581012, 7)
# print("변환 후 y:\n", y[:10])
# print(np.unique(y, return_counts=True))

''' 또는 
# y = y.reshape(-1, 1)
# y = ohe().fit_transform(y)
# y = y.toarray()
'''

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.8, random_state=444, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로
# print(y_train, "\n", y_test)

# 2. 모델구성
model = Sequential()
model.add(Dense(8, input_shape=(54,)))
model.add(Dense(32, activation='relu'))
model.add(Dense(64, activation='relu'))
model.add(Dense(16, activation='sigmoid'))
model.add(Dense(7, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

# 3. 컴파일, 훈련
model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])

earlyStopping = EarlyStopping(monitor='val_loss', mode=min, patience=16, restore_best_weights=True, verbose=3)
model.fit(x_train, y_train, epochs=1024, validation_split=0.2,batch_size=4096, callbacks=earlyStopping, verbose=3)

# 4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis=1)
print('y_predict: ', y_predict[:10])

y_test = np.argmax(y_test, axis=1)
print('y_test: ', y_test[:10])

acc = accuracy_score(y_test, y_predict)
print('accuracy: ', acc)
