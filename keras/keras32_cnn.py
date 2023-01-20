from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Conv2D, Flatten             # Conv2D: 이미지 데이터 모델에 사용

model = Sequential()         
# ---------- CNN ---------- #                                        
model.add(Conv2D(filters=10, kernel_size=(2,2), input_shape=(5,5,1)))  # ex: image = (60000, 5, 5, 1)               
model.add(Conv2D(5, (2,2)))                                            # input_shape = (N, 4, 4, 10) → 행 무시, 열 우선
# ---------- DNN ---------- #
model.add(Flatten())                                                   # input_shape = (N, 3, 3, 5) output_shape = (N, 45) = (45, ) → 행 무시, 열 우선, 
model.add(Dense(units = 10))                                           # (N, 10)
model.add(Dense(4, activation='relu'))                                 # (N, 1)

model.summary()

# filter = channel
# Conv2D parameter: filters = 출력 채널 수 지정, kernel_size = 분할을 수행할 사이즈 지정, input_shape = (batch_size, rows, cols, channel)

# batch_size = 한번에 수행할 훈련 개수
# Dense parameter: units = 출력 뉴런 수 지정, input_shape = (batch_size, input_dim)

# input_shape에는 batch dimension 포함 X



