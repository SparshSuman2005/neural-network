import matplotlib.pyplot as plt
import numpy as np

# =========================
# DATA
# =========================

epochs = [1, 2, 3, 4, 5]

# Java NN
java_cost = [
    1.3857,
    0.4402,
    0.2942,
    0.2252,
    0.1835
]

java_accuracy = [
    0.7216,
    0.9308,
    0.9537,
    0.9653,
    0.9719
]

# Python NN
python_loss = [
    0.3249,
    0.2845,
    0.1966,
    0.1411,
    0.1080
]

python_accuracy = [
    0.1465,
    0.3948,
    0.6229,
    0.7780,
    0.8448
]

# =========================
# 1. EPOCH vs COST/LOSS
# =========================

plt.figure(figsize=(8,5))

plt.plot(epochs, java_cost, marker='o', label='Java NN')
plt.plot(epochs, python_loss, marker='o', label='Python NN')

plt.xlabel("Epoch")
plt.ylabel("Cost / Loss")
plt.title("Epoch vs Cost/Loss")

plt.legend()
plt.grid(True)

plt.show()

# =========================
# 2. EPOCH vs ACCURACY
# =========================

plt.figure(figsize=(8,5))

plt.plot(epochs, java_accuracy, marker='o', label='Java NN')
plt.plot(epochs, python_accuracy, marker='o', label='Python NN')

plt.xlabel("Epoch")
plt.ylabel("Accuracy")
plt.title("Epoch vs Accuracy")

plt.legend()
plt.grid(True)

plt.show()

# =========================
# 3. CONFUSION MATRIX
# JAVA NN ONLY
# =========================

confusion_matrix = np.array([
    [970, 0,   1,  1,  1,  2,  1,  1,  3,  0],
    [0, 1120, 5,  3,  0,  1,  1,  2,  3,  0],
    [5, 3, 1001, 11, 1,  0,  0, 10,  1,  0],
    [1, 0,   1, 993, 0,  4,  0,  5,  5,  1],
    [2, 0,   1,  0, 955, 1,  6,  2,  2, 13],
    [7, 0,   0, 28,  2, 838, 1,  1, 10,  5],
    [11,3,   4,  1,  4,  6, 921, 0,  8,  0],
    [1, 6,   9,  7,  2,  1,  0, 994, 0,  8],
    [2, 1,   7,  9,  3,  3,  4,  2, 941, 2],
    [4, 4,   0, 12,  7,  6,  0,  8,  5, 963]
])

plt.figure(figsize=(10,8))

plt.imshow(confusion_matrix)

plt.colorbar()

classes = [0,1,2,3,4,5,6,7,8,9]

plt.xticks(classes)
plt.yticks(classes)

plt.xlabel("Predicted Label")
plt.ylabel("Actual Label")

plt.title("Java Neural Network Confusion Matrix")

# writing values inside cells
for i in range(10):
    for j in range(10):
        plt.text(
            j,
            i,
            confusion_matrix[i][j],
            ha='center',
            va='center'
        )

plt.show()