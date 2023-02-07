import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

x = np.array(range(1, 21))
y = np.array([1,2,4,3,5,7,9,3,8,12,13,8,14,15,9,6,17,23,21,20])

x_train ,x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=123)

model = Sequential()
model.add(Dense(30, input_dim = 1))
model.add(Dense(20))
model.add(Dense(30))
model.add(Dense(30))
model.add(Dense(10))
model.add(Dense(1))    

model.compile(loss='mse', optimizer = 'adam', metrics = ['mae']) # loss는 학습에 영향을 미친다. → 가중치 갱신에 영향을 미침, metrics는 학습에 영향을 미치지 않는다.
model.fit(x_train, y_train, epochs = 500, batch_size=1)                                                                                                     

loss = model.evaluate(x_test, y_test) 
print('loss: ', loss)

y_predict = model.predict(x_test)
print('y_predict:\n', y_predict)

def RMSE(y_test, y_predict):
    return np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE(y_test, y_predict))