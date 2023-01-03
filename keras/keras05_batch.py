import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([1,2,3,4,5,6])
y = np.array([1,2,3,5,4,6])

model = Sequential()
model.add(Dense(10, input_dim = 1)) # input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(8)) 
model.add(Dense(6))
model.add(Dense(2)) # hidden layer  
model.add(Dense(1)) # output layer

model.compile(loss = 'mae', optimizer = 'adam')
model.fit(x, y, epochs = 100, batch_size = 1)

result = model.predict([6])
print('예측값: ', result)

"""
data_size=6, batch_size = 1 → 데이터 1개씩 분할(갱신 6번)
data_size=6, batch_size = 2 → 데이터 2개씩 분할(갱신 3번) 
data_size=6, batch_size = 3 → 데이터 3개씩 분할(갱신 2번) 
data_size=6, batch_size = 4 → 데이터 4개, 2개 분할(갱신 2번) 
data_size=6, batch_size = 5 → 데이터 5개, 1개 분할(갱신 2번) 
data_size=6, batch_size = 6 → 데이터 6개씩 분할(갱신 1번)
data_size=6, batch_size > 6 → 데이터 6개씩 분할(갱신 1번)
"""