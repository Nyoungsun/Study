# R2를 음수가 아니면서 0.5 이하로 낮추어라.
# 데이터는 수정 X
# 레이어 = input과 output을 합하여 7개 이상
# 배치 크기 = 1
# 히든 레이어의 노드 = 각 10개 이상 100개 이하,  
# train = 70%
# epochs > 100
# loss = mse or mae
# activation 사용 X

import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score

x = np.array(range(1, 21))
y = np.array(range(1, 21))

x_train ,x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=432)

model = Sequential()
model.add(Dense(10, input_dim = 1))
model.add(Dense(10))
model.add(Dense(10))
model.add(Dense(10))
model.add(Dense(10))
model.add(Dense(1))    

model.compile(loss='mse', optimizer = 'adam') # loss는 학습에 영향을 미친다. → 가중치 갱신에 영향을 미침, metrics는 학습에 영향을 미치지 않는다.
model.fit(x_train, y_train, epochs = 100, batch_size=1)                                                                                                     

loss = model.evaluate(x_test, y_test) 
print('loss: ', loss)

y_predict = model.predict(x_test)
print('x_test:\n', x_test)
print('y_predict:\n', y_predict)

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE(y_test, y_predict))

r2 = r2_score(y_test, y_predict)
print("R2: ", r2)