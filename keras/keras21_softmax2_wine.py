from tensorflow.keras.models import Sequential 
from tensorflow.keras.layers import Dense
from sklearn.model_selection import train_test_split
from sklearn.datasets import load_wine
from tensorflow.keras.utils import to_categorical
from sklearn.metrics import accuracy_score
import numpy as np
from sklearn.preprocessing import OneHotEncoder as OHE
import pandas as pd

#1. 데이터
datasets = load_wine()
# print(datasets)
# print(datasets.DESCR) # pandas: .describe() / .info()
# print(datasets.feature_names) # pandas: .columns

x = datasets.data
y = datasets['target']
# print(x.shape, y.shape) # (178, 13), (178,)
# print(np.unique(y, return_counts=True)) # 분류 데이터임을 알 수 있음 → (array([0, 1, 2]), array([59, 71, 48]) 

# y = pd.get_dummies(y) 또는 OHE.fit(y.reshape(-1, 1)) y = OHE.transform(y.reshape(-1, 1)).toarray()
y = to_categorical(y)
# print(y, y.shape)

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state = 444, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로 
# print(y_train, "\n", y_test)

#2. 모델구성
model = Sequential()
model.add(Dense(32, input_shape = (13,)))
model.add(Dense(16))
model.add(Dense(16))
model.add(Dense(16)) 
model.add(Dense(3, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

#3. 컴파일, 훈련
model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics=['accuracy'])
model.fit(x_train, y_train, epochs = 512, validation_split=0.2, verbose = 3) 

#4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis = 1)
print('y_predict: ', y_predict)

y_test = np.argmax(y_test, axis = 1)
print('y_test: ', y_test)

acc = accuracy_score(y_test, y_predict)
print('accuracy: ', acc)
