from tensorflow.keras.datasets import cifar10, cifar100
import numpy as np
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, Dense, Flatten
import datetime 
from tensorflow.keras.callbacks import EarlyStopping,ModelCheckpoint
from sklearn.preprocessing import MinMaxScaler

#1. 데이터
(x_train, y_train), (x_test, y_test) = cifar100.load_data()


date = datetime.datetime.now()
date = date.strftime("%m%d_%H%M")
filepath = './_save/MCP/'
filename = '{epoch:04d}-{val_loss:.4f}.hdf5'  
path = './_save/'

#2. 모델 구성
model = Sequential() 
model.add(Conv2D(filters= 128,kernel_size=(2,2), input_shape=(32,32,3),
        activation='relu'))                       
model.add(Conv2D(filters=64, kernel_size=(2,2))) 
model.add(Conv2D(filters=64, kernel_size=(2,2))) 
model.add(Conv2D(filters=64, kernel_size=(2,2))) 
model.add(Conv2D(filters=32, kernel_size=(2,2))) 
model.add(Conv2D(filters=32, kernel_size=(2,2))) 
model.add(Conv2D(filters=16, kernel_size=(2,2))) 
model.add(Flatten())   
model.add(Dense(128, activation='relu'))  
model.add(Dense(64, activation='relu'))  
model.add(Dense(128, activation='relu')) 
model.add(Dense(64, activation='relu'))  
model.add(Dense(64, activation='relu'))  
model.add(Dense(64, activation='relu'))  
model.add(Dense(100, activation='softmax')) 

#3. 컴파일, 훈련

# mode= auto, min, max 
es = EarlyStopping(monitor='val_loss',
                              mode='min', 
                              patience=30,
                              restore_best_weights=True,
                              verbose=3)

mcp = ModelCheckpoint(monitor='val_loss', mode='auto', verbose=1,
                      save_best_only=True,
                      filepath=filepath + 'k30_' + date+'_' + filename)


model.compile(loss='sparse_categorical_crossentropy', optimizer='adam', 
              metrics=['acc'])
model.fit(x_train, y_train, epochs=1000, verbose=1, batch_size=2560,
          validation_split=0.2,
          callbacks=[es, mcp])

model.save(path + 'keras34_ModelCheckPointcifar_save_model.h5')
#4. 평가, 예측
results = model.evaluate(x_test, y_test)
print('loss :', results[0])
print('acc :', results[1])