from tensorflow.keras.datasets import cifar100
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, Dense, Flatten, Dropout
from tensorflow.keras.callbacks import EarlyStopping, ModelCheckpoint
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
import matplotlib.pyplot as plt
import numpy as np

#1. 데이터
path = 'C:/study/keras_save/MCP/'

(x_train, y_train), (x_test, y_test) = cifar100.load_data()
# print(x_train.shape, y_train.shape) 
# print(x_test.shape, y_test.shape)   

# print(x_train[0], y_train[0])      # 데이터 확인
# plt.imshow(x_train[0], 'gray')     # 이미지 확인
# plt.show()

#2. 모델
model = Sequential()
model.add(Conv2D(filters=128, kernel_size = (2,2), input_shape=(32,32,3), activation='relu'))
model.add(Dropout(0.5)) 
model.add(Conv2D(filters=64, kernel_size=(2,2)))
model.add(Dropout(0.3)) 
model.add(Conv2D(filters=64, kernel_size=(2,2))) 
model.add(Flatten())
model.add(Dense(units=64, activation='relu'))
model.add(Dropout(0.3)) 
model.add(Dense(units=32, activation='relu'))
model.add(Dropout(0.2)) 
model.add(Dense(units=16, activation='relu'))
model.add(Dense(units=100, activation='softmax'))

#3. 컴파일 및 훈련
model.compile(loss='sparse_categorical_crossentropy', optimizer='adam', metrics='acc')

MCP = ModelCheckpoint(monitor='val_loss', mode = 'auto', save_best_only=True, filepath = path + 'keras34_2_cifar100.hdf5') 
ES = EarlyStopping(monitor = 'val_loss', mode = min, patience=4, restore_best_weights = True) 
model.fit(x_train, y_train, epochs=32, batch_size=128, validation_split=0.2, callbacks=[ES, MCP])

#4. 평가 및 예측
metric = model.evaluate(x_test, y_test) # compile에서 metrics = acc를 지정했으므로 evaluate는 값을 배열 형태로 2개 반환함
print('loss: ', metric[0], 'acc: ', metric[1])




