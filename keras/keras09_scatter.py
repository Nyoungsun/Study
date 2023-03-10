import matplotlib.pyplot as plt
import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from sklearn.model_selection import train_test_split

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

model.compile(loss='mae', optimizer = 'adam')
model.fit(x_train, y_train, epochs = 500, batch_size=1)

print('\n')
loss = model.evaluate(x_test, y_test) 
print('loss:', loss)

print('\n')
y_predict = model.predict(x)
print(y_predict)

plt.scatter(x, y, color = 'red')
plt.plot(x, y_predict, color = 'green')
plt.show()