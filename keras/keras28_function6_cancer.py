from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from tensorflow.keras.models import Sequential, Model
from tensorflow.keras.layers import Dense, Input
from sklearn.preprocessing import MinMaxScaler as MMS, StandardScaler as SDS
from tensorflow.keras.callbacks import EarlyStopping
import numpy as np 

#1. 데이터
dataset = load_breast_cancer()        

# print(dataset)
# print(dataset.DESCR)
# print(dataset.feature_names)

x = dataset['data']  # x = dataset.data               
y = dataset['target']      

# print(x.shape, y.shape) # (569, 30), (569,)

x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=3333)

# scaler = MMS()
scaler = SDS()
x_train = scaler.fit_transform(x_train)
x_test = scaler.transform(x_test)

#2. 모델구성
# model = Sequential()
# model.add(Dense(32, input_shape = (30,)))
# model.add(Dense(16))
# model.add(Dense(16, activation='relu'))
# model.add(Dense(8, activation='relu'))
# model.add(Dense(1, activation='sigmoid')) # sigmoid: 0~1 사이의 값으로 → 이진 분류에서 사용, 보통 출력 층에서 사용

# (functional)
input = Input(shape=(30,))
dense1 = Dense(32)(input)
dense2 = Dense(16)(dense1)
dense3 = Dense(16, activation= 'relu')(dense2)
dense4 = Dense(8, activation= 'relu')(dense3)
output = Dense(1, activation='sigmoid')(dense4)
model = Model(inputs=input, outputs=output)
# model.summary()

#3. 컴파일 및 훈련
model.compile(loss = 'binary_crossentropy', optimizer='adam', metrics=['accuracy']) # 이진분류 loss = binary_crossentropy

earlyStopping = EarlyStopping(monitor='val_loss', mode='min', patience=16, restore_best_weights=True) # loss - min, accuracy - max 
# earlyStopping = EarlyStopping(monitor='accuracy', mode='max', patience=20, restore_best_weights=True) 
hist = model.fit(x_train, y_train, epochs=1024, batch_size=16, validation_split=0.2, callbacks = [earlyStopping], verbose = 3) # verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지

#4. 평가 및 예측
loss, accuracy = model.evaluate(x_test, y_test)
print('loss: ', loss, 'accuracy: ', accuracy)

y_predict = np.where(model.predict(x_test) > 0.5, 1, 0) # y_predict = y_predict.round()
y_predict = y_predict.flatten()
print('y_predict: \n', y_predict[:10], '\n y_test: ', y_test[:10])

acc = accuracy_score(y_test, y_predict) 
print('acc: ', acc)

# print(hist.history['val_loss']) # metrics를 넣으면 history에 metrics에 대한 수치도 나온다.
# print(hist.history['accuracy'])

# MMS acc:  0.9649122807017544
# SDS acc:  0.9883040935672515