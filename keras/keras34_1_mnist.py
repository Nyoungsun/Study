from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, Dense, Flatten
from tensorflow.keras.callbacks import EarlyStopping, ModelCheckpoint
import matplotlib.pyplot as plt
import numpy as np

#1. 데이터
(x_train, y_train), (x_test, y_test) = mnist.load_data()
# print(x_train.shape, y_train.shape) # (60000, 28, 28) (60000,)
# print(x_test.shape, y_test.shape)   # (10000, 28, 28) (10000,)

# print(x_train[0], y_train[0])      # 데이터 확인
# plt.imshow(x_train[0], 'gray')     # 이미지 확인
# plt.show()

# ---------- 전처리 (4차원으로 변환) ---------- #
x_train = x_train.reshape(60000, 28, 28, 1)
x_test = x_test.reshape(10000, 28, 28, 1)
# print(x_train.shape) (60000, 28, 28, 1)
# print(x_test.shape) (10000, 28, 28, 1)
# print(np.unique(y_train, return_counts = True)) # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [5923, 6742, 5958, 6131, 5842, 5421, 5918, 6265, 5851, 5949]

#2. 모델
model = Sequential()
model.add(Conv2D(filters=128, kernel_size = (2,2), input_shape=(28,28,1), activation='relu', activation='relu'))
model.add(Conv2D(filters=64, kernel_size=(2,2), padding='same', activation='relu')) # input_size = (27, 27, 128)
model.add(Conv2D(filters=32, kernel_size=(2,2), activation='relu')) # input_size = (26, 26, 64)
model.add(Conv2D(filters=16, kernel_size=(2,2), activation='relu'))
model.add(Conv2D(filters=8, kernel_size=(2,2), activation='relu'))
model.add(Flatten())
model.add(Dense(units=16, activation='relu'))
model.add(Dense(units=10, activation='softmax'))

#3. 컴파일 및 훈련
model.compile(loss='sparse_categorical_crossentropy', optimizer='adam', metrics='acc') # one-hot encoding 하지 않아도 되는 데이터이므로 loss= sparse_categorical_crossentropy

path = 'C:/study/keras/keras_save/MCP/'
MCP = ModelCheckpoint(monitor='val_loss', mode = 'auto', save_best_only=True, filepath = path + 'keras34_1_mnist.hdf5') 
ES = EarlyStopping(monitor = 'val_loss', mode = min, patience=4, restore_best_weights = True) 
model.fit(x_train, y_train, epochs=32, batch_size=256, validation_split=0.1, callbacks=[ES, MCP])

#4. 평가 및 예측
metric = model.evaluate(x_test, y_test, batch_size=1024) # compile에서 metrics = acc를 지정했으므로 evaluate는 값을 배열 형태로 2개 반환함
print('loss: ', metric[0], 'acc: ', metric[1])

# acc:  0.972100019454956