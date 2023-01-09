from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error, r2_score
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc


# 1. 데이터
dataset = load_boston()         # 보스턴 집 값에 대한 데이터
x = dataset.data                # 방 넓이, 방 개수 등 → 독립변수
y = dataset.target              # 집 값 → 종속변수

# print(x)
# print(x.shape)                  # (506, 13)
# print(y)
# print(y.shape)                  # (506,)
# print(dataset.feature_names)    # ['CRIM' 'ZN' 'INDUS' 'CHAS' 'NOX' 'RM' 'AGE' 'DIS' 'RAD' 'TAX' 'PTRATIO' 'B' 'LSTAT']
# print(dataset.DESCR)            # Missing Attribute Values: 결측치 - 데이터에 값이 없는 것

x_train, x_test, y_train, y_test = train_test_split(
    x, y, train_size=0.7, random_state=3333
)

# 2. 모델구성
model = Sequential()
model.add(Dense(32, input_shape=(13,)))
model.add(Dense(64))
model.add(Dense(256))
model.add(Dense(512))
model.add(Dense(128))
model.add(Dense(1))


# 3. 컴파일 및 훈련
model.compile(loss='mse', optimizer='adam')
# verbose: 함수 수행시 발생하는 상세한 정보들을 표준 출력으로 자세히 내보낼 것인지
hist = model.fit(x_train, y_train, epochs=1, batch_size=1,
                 validation_split=0.2, verbose=3)

# 4. 평가 및 예측
loss = model.evaluate(x_test, y_test, verbose=3)
y_predict = model.predict(x_test)
# print('x_test:\n', x_test)
# print('y_predict:\n', y_predict)
print('loss: ', loss)

# print(hist) # <keras.callbacks.History object at 0x000001ECB4986D00>
# print(hist.history) # 딕셔너리(key, value) → loss의 변화값을 list로(value는 list로 저장된다.)
# print(hist.history['loss']) # key = loss인 것만 출력

RMSE = np.sqrt(mean_squared_error(y_test, y_predict))
print("RMSE: ", RMSE)
r2 = r2_score(y_test, y_predict)
print("R2: ", r2)

# --------------------- 시각화 ----------------------- #
plt.figure(figsize=(9, 6))
plt.plot(hist.history['loss'], c='red', marker='.', label='loss')
plt.plot(hist.history['val_loss'], c='blue', marker='.', label='val_loss')
plt.grid()
plt.xlabel('epochs')
plt.ylabel('loss')
plt.legend()  # label 출력 # plt.legend(loc = 'upper left')
font_path = "C:/Windows/Fonts/malgun.ttf"
plt.rc('font', family='malgun')
font = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font)
plt.title("보스턴")
plt.show()
