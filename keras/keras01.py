import tensorflow as tf
import numpy as np
print(tf.__version__) 

#1. 데이터
x = np.array([1, 2, 3])
y = np.array([1, 2, 3])

#2. 모델구성
from tensorflow.keras.models import Sequential #순차적 모델
from tensorflow.keras.layers import Dense      #모델 구성 방법

model = Sequential()
model.add(Dense(1, input_dim=1)) #1 = y(output_dim) → 1차원 배열

#3. 컴파일, 훈련
model.compile(loss='mae', optimizer='adam') #mae = mean absolute error, optimizer → loss 최적화
model.fit(x, y, epochs=2000) #epochs = 훈련 횟수

#4. 평가, 예측
result = model.predict([4])
print('결과: ', result)