from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.callbacks import EarlyStopping 
import numpy as np
import matplotlib.pyplot as plt

#1. 데이터
dataset = load_breast_cancer()        

# print(dataset)
# print(dataset.DESCR)
# print(dataset.feature_names)

x = dataset['data']  # x = dataset.data               
y = dataset['target']      

# print(x.shape, y.shape) # (569, 30), (569,)

x_train, x_test, y_train, y_test = train_test_split(
    x, y, train_size=0.7, random_state=3333
)

#2. 모델구성
model = Sequential()
model.add(Dense(32, activation='linear', input_shape = (30,)))
model.add(Dense(64, activation='relu'))
model.add(Dense(256, activation='relu'))
model.add(Dense(128, activation='relu'))
model.add(Dense(128, activation='relu'))
model.add(Dense(1, activation='sigmoid'))

#3. 컴파일 및 훈련
model.compile(loss = 'binary_crossentropy', optimizer='adam', metrics=['accuracy']) # 이진분류 loss = binary_crossentropy
earlyStopping = EarlyStopping(monitor='val_loss', mode='min', patience=20, restore_best_weights=True) # loss - min, accuracy - max 
model.fit(x_train, y_train, epochs=1000, batch_size=16, validation_split=0.2, callbacks = [earlyStopping], verbose = 2) # verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지

#4. 평가 및 예측
loss, accuracy = model.evaluate(x_test, y_test)
y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)
print('loss: ', loss , 'accuracy: ', accuracy) 