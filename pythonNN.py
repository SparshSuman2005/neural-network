import numpy as np
import tensorflow as tf
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Input, Flatten, Dense
from tensorflow.keras.optimizers import SGD
from sklearn.metrics import confusion_matrix, accuracy_score

# Load MNIST dataset
(x_train, y_train), (x_test, y_test) = mnist.load_data()

# Normalize pixels: 0-255 -> 0-1
x_train = x_train / 255.0
x_test = x_test / 255.0

# Same idea as your Java network:
# 784 -> 128 -> 64 -> 32 -> 10
model = Sequential([
    Input(shape=(28, 28)),
    Flatten(),
    Dense(128, activation="sigmoid"),
    Dense(64, activation="sigmoid"),
    Dense(32, activation="sigmoid"),
    Dense(10, activation="sigmoid")
])

# Similar to your Java project:
# SGD = simple gradient descent
# binary_crossentropy = BCE
model.compile(
    optimizer=SGD(learning_rate=0.01),
    loss="binary_crossentropy",
    metrics=["accuracy"]
)

# Convert labels to one-hot because BCE needs 10 output labels
y_train_onehot = tf.keras.utils.to_categorical(y_train, 10)
y_test_onehot = tf.keras.utils.to_categorical(y_test, 10)

# Train
model.fit(
    x_train,
    y_train_onehot,
    epochs=5,
    batch_size=1,
    shuffle=True
)

# Test
test_loss, test_accuracy = model.evaluate(x_test, y_test_onehot)
print("Test loss:", test_loss)
print("Test accuracy:", test_accuracy)

# Predictions
y_pred_probs = model.predict(x_test)
y_pred = np.argmax(y_pred_probs, axis=1)

# Accuracy
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

# Confusion matrix
cm = confusion_matrix(y_test, y_pred)
print("Confusion Matrix:")
print(cm)

# TP, FP, TN, FN for each digit
print("Digit    TP      FP      TN      FN")

for digit in range(10):
    tp = cm[digit][digit]
    fp = cm[:, digit].sum() - tp
    fn = cm[digit, :].sum() - tp
    tn = cm.sum() - tp - fp - fn

    print(f"{digit:5d} {tp:6d} {fp:7d} {tn:7d} {fn:7d}")