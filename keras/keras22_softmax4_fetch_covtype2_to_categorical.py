from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.callbacks import EarlyStopping
from sklearn.model_selection import train_test_split
from sklearn.datasets import fetch_covtype
from tensorflow.keras.utils import to_categorical
from sklearn.metrics import accuracy_score
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

y = to_categorical(y)
# print(type(y), y.shape)  # <class 'numpy.ndarray'>, (581012, 8)
y = np.delete(y, 0, axis=1) # 0열이 추가되기 때문에 제거
# print(np.unique(y[:,0], return_counts=True)) # y[:,0]: y의 모든 열의 0번째 열, unique(): 데이터에 고유값들이 어떠한 종류들이 있는지

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.8, random_state=444, stratify=y) # shuffle = False 일 때: 값이 치중될 수 있음, stratify = y: 동일한 비율로
# print(y_train, "\n", y_test)

# 2. 모델구성
model = Sequential()
model.add(Dense(16, input_shape=(54,)))
model.add(Dense(32))
model.add(Dense(16, activation='sigmoid'))
model.add(Dense(16, activation='sigmoid'))
model.add(Dense(7, activation='softmax')) # 확률의 총합 = 1, 다중 분류에서 사용, 보통 출력 층에서 사용

# 3. 컴파일, 훈련
model.compile(loss='categorical_crossentropy',optimizer='adam', metrics=['accuracy'])

earlyStopping = EarlyStopping(monitor='val_loss', mode=min, patience=16, restore_best_weights=True, verbose=3)
model.fit(x_train, y_train, epochs=1024, validation_split=0.2,batch_size=4096, callbacks=earlyStopping, verbose=3)

# 4. 평가, 예측
loss, accuracy = model.evaluate(x_test, y_test)
print("loss: ", loss, "accuaracy: ", accuracy)

y_predict = np.argmax(model.predict(x_test), axis=1)
print('y_predict: ', y_predict)
print(y_test)

y_test = np.argmax(y_test, axis=1)
print('y_test: ', y_test)

acc = accuracy_score(y_test, y_predict)
print('accuracy: ', acc)
