import numpy as np 
from sklearn.model_selection import train_test_split
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

x = np.array([1,2,3,4,5,6,7,8,9,10]) 
y = np.array(range(10))

x_train, x_test, y_train, y_test = train_test_split(
    x, y, 
    test_size=0.3,
    train_size=0.7,     #train, test 중 하나만 지정해도됨
    shuffle=True,       #default = True
    random_state=140     #random_state 지정 = random seed 고정
    )

model = Sequential()
model.add(Dense(20, input_dim = 1))
model.add(Dense(30))
model.add(Dense(20))
model.add(Dense(10))
model.add(Dense(1))

model.compile(loss='mae', optimizer = 'adam')
model.fit(x_train, y_train, epochs=300, batch_size=1) # 훈련 데이터로만 훈련해야함

print('\n')
loss = model.evaluate(x_test, y_test) # 평가 데이터로만 평가해야함 (훈련 데이터 범위 내에서 평가 데이터를 분리)
print('loss: ', loss)

print('\n')
result = model.predict([11])
print('[11]의 결과: ', result)

#test