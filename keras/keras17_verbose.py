from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import numpy as np
import time as t
import matplotlib as mp

#1. 데이터
dataset = load_boston()         # 보스턴 집 값에 대한 데이터
x = dataset.data                # 방 넓이, 방 개수 등 → 독립변수
y = dataset.target              # 집 값 → 종속변수

# print(x)
# print(x.shape)                  # (506, 13)
# print(y)
# print(y.shape)                  # (506,)
# print(dataset.feature_names)    # ['CRIM' 'ZN' 'INDUS' 'CHAS' 'NOX' 'RM' 'AGE' 'DIS' 'RAD' 'TAX' 'PTRATIO' 'B' 'LSTAT']
# print(dataset.DESCR)            # Missing Attribute Values: 결측치 - 데이터에 값이 없는 것

#2. 모델구성
x_train, x_test, y_train, y_test = train_test_split(
    x, y, train_size=0.2, random_state=3333
)

model = Sequential()
model.add(Dense(32, input_shape = (13,))) #input_dim = 13과 같음(input_shape: 다차원 데이터에 사용)
model.add(Dense(128))
model.add(Dense(256, activation='relu'))
model.add(Dense(64, activation='relu'))
model.add(Dense(16, activation='relu'))
model.add(Dense(1))

#3. 컴파일 및 훈련
model.compile(loss = 'mse', optimizer='adam')
start = t.time()
model.fit(x_train, y_train, epochs=100, batch_size=1, validation_split=0.2, verbose = 3) #verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지
end = t.time()

#4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)
print('loss: ', loss)
print("걸린시간: ", end - start)
# verbose=1일때, 11.9초
# verbose=2일때, 11.2초 (progress bar 출력 X)
# verbose=3일때, 11.0초 (epochs만 출력)
# verbose=0일때, 10.7초


# RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
# print("RMSE: ", RMSE(y_test, y_predict))
# r2 = r2_score(y_test, y_predict)
# print("R2: ", r2)

# #R2 = 0.74