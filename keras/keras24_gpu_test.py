import tensorflow as tf

GPU = tf.config.experimental.list_physical_devices("GPU") 
# print(GPU) # [PhysicalDevice(name='/physical_device:GPU:0', device_type='GPU')]

if(GPU): 
    print("GPU")
else:
    print("CPU")