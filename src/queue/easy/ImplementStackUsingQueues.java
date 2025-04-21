// https://leetcode.com/problems/implement-stack-using-queues/description/

package queue.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;
    int currentQueue;

    public ImplementStackUsingQueues() {
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
        currentQueue = 1;
    }

    public void push(int x) {
        if (currentQueue == 1) {
            queueOne.offer(x);
        } else {
            queueTwo.offer(x);
        }
    }

    public int pop() {
        int result = 0;
        if (currentQueue == 1) {
            while (queueOne.size() > 1) {
                queueTwo.offer(queueOne.poll());
            }
            result = queueOne.poll();
            currentQueue = 2;
        } else {
            while (queueTwo.size() > 1) {
                queueOne.offer(queueTwo.poll());
            }
            result = queueTwo.poll();
            currentQueue = 1;
        }
        return result;
    }

    public int top() {
        int result = 0;
        if (currentQueue == 1) {
            while (queueOne.size() > 0) {
                if (queueOne.size() == 1) {
                    result = queueOne.peek();
                }
                queueTwo.offer(queueOne.poll());
            }
            currentQueue = 2;
        } else {
            while (queueTwo.size() > 0) {
                if (queueTwo.size() == 1) {
                    result = queueTwo.peek();
                }
                queueOne.offer(queueTwo.poll());
            }
            currentQueue = 1;
        }
        return result;
    }

    public boolean empty() {
        return queueTwo.isEmpty() && queueOne.isEmpty();
    }
}

class ImplementStackUsingQueuesTest {
    public static void main(String[] args) {
        ImplementStackUsingQueues implementStackUsingQueues = new ImplementStackUsingQueues();
        implementStackUsingQueues.push(1);
        implementStackUsingQueues.push(2);
        System.out.println(implementStackUsingQueues.top());
        System.out.println(implementStackUsingQueues.pop());
        System.out.println(implementStackUsingQueues.empty());

    }
}
