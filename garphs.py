
import matplotlib.pyplot as plt
import numpy as np

epochs = np.array([1, 2, 3, 4, 5])

java_cost = np.array([
    1.3857,
    0.4402,
    0.2942,
    0.2252,
    0.1835
])

java_accuracy = np.array([
    0.7216,
    0.9308,
    0.9537,
    0.9653,
    0.9719
])

python_loss = np.array([
    0.3249,
    0.2845,
    0.1966,
    0.1411,
    0.1080
])

python_accuracy = np.array([
    0.1465,
    0.3948,
    0.6229,
    0.7780,
    0.8448
])

smooth_x = np.linspace(epochs.min(), epochs.max(), 300)

java_curve = np.poly1d(np.polyfit(epochs, java_cost, 3))
python_curve = np.poly1d(np.polyfit(epochs, python_loss, 3))

plt.figure(figsize=(10,6))

plt.plot(
    smooth_x,
    java_curve(smooth_x),
    linewidth=3,
    label="Java NN Cost"
)

plt.plot(
    smooth_x,
    python_curve(smooth_x),
    linewidth=3,
    label="Python NN Loss"
)

plt.scatter(epochs, java_cost, s=80)
plt.scatter(epochs, python_loss, s=80)

plt.xlabel("Epoch")
plt.ylabel("Cost / Loss")
plt.title("Epoch vs Cost/Loss")

plt.legend()
plt.grid(True)

plt.xlim(left=0)
plt.ylim(bottom=0)

plt.show()

smooth_x2 = np.linspace(epochs.min(), epochs.max(), 300)

java_acc_curve = np.poly1d(np.polyfit(epochs, java_accuracy, 3))
python_acc_curve = np.poly1d(np.polyfit(epochs, python_accuracy, 3))

plt.figure(figsize=(10,6))

plt.plot(
    smooth_x2,
    java_acc_curve(smooth_x2),
    linewidth=3,
    label="Java NN Accuracy"
)

plt.plot(
    smooth_x2,
    python_acc_curve(smooth_x2),
    linewidth=3,
    label="Python NN Accuracy"
)

plt.scatter(epochs, java_accuracy, s=80)
plt.scatter(epochs, python_accuracy, s=80)

plt.xlabel("Epoch")
plt.ylabel("Accuracy")
plt.title("Epoch vs Accuracy")

plt.legend()
plt.grid(True)

plt.xlim(left=0)
plt.ylim(bottom=0)

plt.show()

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
