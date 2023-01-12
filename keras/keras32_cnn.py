from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Conv2D, Flatten # Conv2D: 평면 이미지


model = Sequential()

model.add(Conv2D(filters=10, kernel_size=(2,2), input_shape = (5,5,1))) # filter = 이미지 개수 지정, input_shape = 입력되는 이미지 사이즈, kernel_size = 이미지 분할 사이즈
model.add(Conv2D(5, kernel_size=(2,2))) 
model.add(Flatten())
model.add(Dense(10))
model.add(Dense(1))
model.summary()