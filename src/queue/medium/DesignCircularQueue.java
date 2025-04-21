// https://leetcode.com/problems/design-circular-queue/description/

package queue.medium;

import stack.medium.DailyTemperatures;

public class DesignCircularQueue {

    int[] queue;
    int rear;
    int front;
    int size;
    int capacity;

    public DesignCircularQueue(int k) {
        queue = new int[k];
        rear = -1;
        front = 0;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

class DesignCircularQueueTest {
    public static void main(String[] args) {

        DesignCircularQueue myCircularQueue = new DesignCircularQueue(3);
        myCircularQueue.enQueue(3); // return True
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.deQueue());
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
    }
}
