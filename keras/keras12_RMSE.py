import matplotlib.pyplot as plt
import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.model_selection import train_test_split

x = np.array(range(1, 21))
y = np.array([1,2,4,3,5,7,9,3,8,12,13,8,14,15,9,6,17,23,21,20])

x_train ,x_test, y_train, y_test = train_test_split(
    x,y,
    train_size=0.7,
    random_state=123
)

model = Sequential()
model.add(Dense(30, input_dim = 1))
model.add(Dense(20))
model.add(Dense(30))
model.add(Dense(30))
model.add(Dense(10))
model.add(Dense(1))

model.compile(loss='rmse', optimizer = 'adam', metrics = ['mae']) # loss는 학습에 영향을 미친다. → 가중치 갱신에 영향을 미침, metrics는 학습에 영향을 미치지 않는다.
model.fit(x_train, y_train, epochs = 500, batch_size=1)                                                                                                     

print('\n')
loss = model.evaluate(x_test, y_test) # 랜덤으로 test와 train을 여러 회 분할하여 전체 데이터를 train과 test 데이터로 사용하게한다.
print('loss:', loss)

print('\n')
y_predict = model.predict(x)
print(y_predict)