package heap;

import java.util.Arrays;

public class HeapCreation {

    int size;
    int currentSize;
    int[] array;

    public HeapCreation(int[] array) {
        this.size = array.length;
        this.currentSize = size;
        this.array = array;
        int largeElement = (size / 2) - 1;
        for (int i = largeElement; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    private void heapify(int[] array, int size, int start) {
        int largest = start;
        int leftChild = 2 * start + 1;
        int rightChild = 2 * start + 2;
        if (rightChild < size && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (leftChild < size && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (largest != start) {
            int temp = array[largest];
            array[largest] = array[start];
            array[start] = temp;
            heapify(array, size, largest);
        }
    }

    public int pop() {
        int top = array[0];
        int last = array[currentSize - 1];
        array[0] = last;
        array[currentSize - 1] = top;
        currentSize--;
        int largeElement = (currentSize / 2) - 1;
        for (int i = largeElement; i >= 0; i--) {
            heapify(array, currentSize, i);
        }
        return top;
    }
}

class HeapCreationTest {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        HeapCreation heapCreation = new HeapCreation(array);
        System.out.println(Arrays.toString(array));
        System.out.println(heapCreation.pop());
        System.out.println(heapCreation.pop());
        System.out.println(heapCreation.pop());
        System.out.println(Arrays.toString(array));
    }
}
