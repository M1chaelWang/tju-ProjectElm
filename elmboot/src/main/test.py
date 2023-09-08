import numpy as np
import sys
from keras.models import load_model
model = load_model('D:\\project-summer-2023\\MLearn\\my_model.h5')

def main():
    a = int(sys.argv[1])
    b = float(sys.argv[2])
    c = float(sys.argv[3])
    d = bool(sys.argv[4])
    features = np.array([[a,b,c,d]])
    print(model.predict(features))
    sys.stdout.flush()

if __name__=="__main__":
    main()