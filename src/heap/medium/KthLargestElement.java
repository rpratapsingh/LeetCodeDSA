// https://leetcode.com/problems/kth-largest-element-in-an-array/description
package heap.medium;

public class KthLargestElement {

    private int size;
    private int currentSize;
    private int[] array;

    public int findKthLargest(int[] nums, int k) {
        array = nums;
        currentSize = nums.length;
        size = nums.length;
        int lastNonLeafNode = (size / 2) - 1;
        for (int i = lastNonLeafNode; i >= 0; i--) {
            heapify(i);
        }
        int top = -1;
        for (int i = 0; i < k; i++) {
            top = pop();
        }
        return top;
    }

    private int pop() {
        int last = array[currentSize - 1];
        int top = array[0];
        array[0] = last;
        array[currentSize - 1] = top;
        currentSize--;
        heapify(0);
        return top;
    }

    private void heapify(int start) {
        int largestNode = start;
        int leftChild = 2 * start + 1;
        int rightChild = 2 * start + 2;
        if (rightChild < currentSize && array[rightChild] > array[largestNode]) {
            largestNode = rightChild;
        }
        if (leftChild < currentSize && array[leftChild] > array[largestNode]) {
            largestNode = leftChild;
        }
        if (largestNode != start) {
            int temp = array[largestNode];
            array[largestNode] = array[start];
            array[start] = temp;
            heapify(largestNode);
        }
    }
}

class KthLargestElementTest {
    public static void main(String[] args) {
        int[] input = {2,1};
        int k = 2;
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(input, k));
    }
}
