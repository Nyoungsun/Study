from tensorflow.keras.datasets import mnist
import matplotlib.pyplot as plt

# 1. 데이터
(x_train, y_train), (x_test, y_test) = mnist.load_data()
# print(x_train.shape, y_train.shape) # (60000, 28, 28) (60000,)
# print(x_test.shape, y_test.shape)   # (10000, 28, 28) (10000,)

# print(x_train[0], y_train[0])    # 데이터 확인
# plt.imshow(x_train[0], 'gray')     # 이미지 확인
# plt.show()



