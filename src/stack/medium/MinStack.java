//https://leetcode.com/problems/min-stack/description/

package stack.medium;

class DoubleNode {
    int value;
    DoubleNode previous;
    DoubleNode next;
    int min;

    public DoubleNode(int value) {
        this.value = value;
    }

    public DoubleNode(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

public class MinStack {
    DoubleNode head, tail;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new DoubleNode(val, val);
            tail = head;
        } else {
            int min;
            DoubleNode temp;
            if (val < tail.min) {
                temp = new DoubleNode(val, val);
            } else {
                temp = new DoubleNode(val, tail.min);
            }
            temp.previous = tail;
            tail.next = temp;
            tail = temp;
        }
    }

    public void pop() {
        if (tail == head) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.previous;
        tail.next = null;
    }

    public int top() {
        return tail.value;
    }

    public int getMin() {
        return tail.min;
    }
}


class MinStackTest {
    public static void main(String[] args) {
        MinStack min = new MinStack();
        min.push(1);
        min.push(2);
        min.push(3);
        min.push(4);
        min.push(-1);
        System.out.println(min.getMin());
        min.pop();
        min.pop();
        System.out.println(min.top());
        System.out.println(min.getMin());
    }
}


