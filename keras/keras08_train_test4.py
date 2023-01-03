import numpy as np
from sklearn.model_selection import train_test_split
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

#1.데이터
x = np.array([range(10), range(21,31), range(201, 211)]) #(3,10)
y = np.array([[1,2,3,4,5,6,7,8,9,10], [1,1,1,1,2,1.3,1.4,1.5,1.6,1.4]]) #(2,10) 

x = x.T
y = y.T

x_train, x_test, y_train, y_test = train_test_split(
    x, y, 
    test_size=0.3,       #train, test 중 하나만 지정해도됨
    random_state=140     #random_state 지정 = random seed 고정
    )

print(x_train, "\n\n", x_test, "\n\n", y_train, "\n\n", y_test)

#2. 모델구성
model = Sequential()
model.add(Dense(10, input_dim = 3)) # input_dim = 열(column, feature)의 개수, input layer를 제외하고는 input을 입력하지 않아도 됨
model.add(Dense(30))
model.add(Dense(25))
model.add(Dense(10)) # hidden layer  
model.add(Dense(2)) # output layer

#3. 컴파일, 훈련
model.compile(loss = 'mae', optimizer = 'adam')
model.fit(x, y, epochs = 1000, batch_size = 1) # 가중치와 바이어스가 생성됨

#4. 평가, 예측
print('\n')
loss = model.evaluate(x, y) # loss 값 (실제값과 예측값의 오차) 반환 → 모델의 평가 기준 = loss(loss가 작을 수록 좋은 모델)
print('loss: ', loss)

print('\n')
result = model.predict([[9, 30, 210]]) 
print('예측값: ', result)