from sklearn.datasets import load_boston

dataset = load_boston() # 보스턴 집 값에 대한 데이터
x = dataset.data # 방 넓이, 방 개수 등
y = dataset.target # 집 값

print(x)
print(x.shape)
print(y)
print(y.shape)