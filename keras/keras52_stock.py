import numpy as np
import pandas as pd
from tensorflow.keras.models import Model
from tensorflow.keras.layers import Dense, Dropout, Input, LSTM, concatenate
from tensorflow.keras.callbacks import EarlyStopping, ModelCheckpoint
from sklearn. preprocessing import MinMaxScaler
from sklearn.model_selection import train_test_split


PATH = 'C:/Users/nys/study/keras/keras_data/stock/'

samsung = pd.read_csv(PATH + '삼성전자 주가.csv', header=0, index_col=None, sep=',', encoding='cp949', thousands=',').loc[::-1]
# print(samsung)
# print(samsung.shape) #(1980, 17)

amore = pd.read_csv(PATH + '아모레퍼시픽 주가.csv', header=0, index_col=None, sep=',', encoding='cp949', thousands=',').loc[::-1]
# print(amore)
# print(amore.shape)   #(2220, 17)

# 삼성전자 x ,y 추출
samsung_x = samsung[['고가', '저가','종가', '외인(수량)', '기관']]
samsung_y = samsung[['시가']].to_numpy() # x 데이터는 아래에서 split 함수를 거치며 numpy array로 변환되므로 y는 여기서 변환해준다
# print(samsung_x)
# print(samsung_y)
# print(samsung_x.shape) # (1980, 5)
# print(samsung_y.shape) # (1980, 1)

# 아모레 x, y 추출
amore_x = amore.loc[1980:1,['고가', '저가', '종가', '외인(수량)', '시가']]
# print(amore)
# print(amore.shape) #(1980, 5)

samsung_x = MinMaxScaler().fit_transform(samsung_x)
amore_x = MinMaxScaler().fit_transform(amore_x)

def split_data(dataset, timesteps):
    tmp = []
    for i in range(len(dataset) - timesteps + 1):
        subset = dataset[i : (i + timesteps)]
        tmp.append(subset)
    return np.array(tmp)

samsung_x = split_data(samsung_x, 5)
amore_x = split_data(amore_x, 5)
# print(samsung_x.shape) #(1976, 5, 5)
# print(amore_x.shape) #(1976, 5, 5)

samsung_y = samsung_y[4:, :] # x 데이터와 shape을 맞춰주기 위해 4개 행 제거
# print(samsung_y.shape) #(1976, 1)

# 예측에 사용할 데이터 추출 (마지막 값)
samsung_x_predict = samsung_x[-1].reshape(-1, 5, 5)
amore_x_predict = amore_x[-1].reshape(-1, 5, 5)
# print(samsung_x_predict.shape) # (5, 5, 1)
# print(amore_x_predict.shape) # (5, 5, 1)

samsung_x_train, samsung_x_test, samsung_y_train, samsung_y_test, amore_x_train, amore_x_test  = train_test_split(
    samsung_x, samsung_y, amore_x, train_size=0.7, random_state=333)

print(samsung_x_train.shape, samsung_x_test.shape)  # (1383, 5, 5) (593, 5, 5)
print(samsung_y_train.shape, samsung_y_test.shape) # (1383, 1) (593, 1)
print(amore_x_train.shape, amore_x_test.shape)  # (1383, 5, 5) (593, 5, 5)


# 삼성전자
samsung_input = Input(shape=(5, 5))
samsung_layer1 = LSTM(128, return_sequences=True,activation='relu')(samsung_input)
samsung_layer1 = Dropout(0.2)(samsung_layer1)
samsung_layer2 = LSTM(512, activation='relu')(samsung_layer1)
samsung_layer3 = Dense(256, activation='relu')(samsung_layer2)
samsung_layer4 = Dropout(0.2)(samsung_layer3)
samsung_layer5 = Dense(512, activation='relu')(samsung_layer4)
samsung_layer6 = Dense(128, activation='relu')(samsung_layer5)
samsung_layer6 = Dense(16, activation='relu')(samsung_layer6)
samsung_output = Dense(1)(samsung_layer6)

# 아모레퍼시픽
amore_input = Input(shape=(5, 5))
amore_layer1 = LSTM(128, return_sequences=True,activation='relu')(amore_input)
amore_layer1 = Dropout(0.2)(amore_layer1)
amore_layer2 = LSTM(512, activation='relu')(amore_layer1)
amore_layer3 = Dense(256, activation='relu')(amore_layer2)
amore_layer4 = Dropout(0.2)(amore_layer3)
amore_layer5 = Dense(512, activation='relu')(amore_layer4)
amore_layer6 = Dense(128, activation='relu')(amore_layer5)
amore_layer6 = Dense(16, activation='relu')(amore_layer6)
amore_output = Dense(1)(amore_layer6)

# 병합
merge_layer1 = concatenate([samsung_output, amore_output])
merge_layer2 = Dense(256, activation='relu')(merge_layer1)
merge_layer3 = Dense(128, activation='relu')(merge_layer2)
merge_layer4 = Dense(512, activation='relu')(merge_layer3)
merge_layer5 = Dense(32, activation='relu')(merge_layer4)
merge_output = Dense(1, activation='relu')(merge_layer5)

model = Model(inputs=[samsung_input, amore_input], outputs=[merge_output])
model.summary()

model.compile(loss='mse', optimizer= 'adam')

ES = EarlyStopping(monitor='val_loss', mode='auto', patience=32, restore_best_weights=True)
MCP = ModelCheckpoint(monitor='val_loss', mode='auto', save_best_only=True,filepath = PATH + 'stock_ModelCheckPoint.hdf5') # 모델과 가중치 저장

model.fit([samsung_x_train, amore_x_train], samsung_y_train , epochs=1024, batch_size=1024, validation_split=0.2, callbacks=[ES, MCP])

model.save_weights(PATH + 'stock_weight.h5') # 가중치만 저장

#4. 평가, 예측
loss=model.evaluate([samsung_x_test, amore_x_test], samsung_y_test, batch_size=1024)
samsung_y_predict=model.predict([samsung_x_predict, amore_x_predict])

print("loss : ", loss)
print("삼성전자 시가 :" , samsung_y_predict)