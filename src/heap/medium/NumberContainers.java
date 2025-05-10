package heap.medium;

import java.util.*;

public class NumberContainers {

    Map<Integer, Integer> list = new HashMap<>();
    Map<Integer, PriorityQueue<Integer>> minIndexMap = new HashMap<>();

    public void change(int index, int number) {
        list.put(index, number);
        PriorityQueue<Integer> putQueue = minIndexMap.get(number);
        if (putQueue == null) {
            putQueue = new PriorityQueue<>();
        }
        putQueue.offer(index);
        minIndexMap.put(number, putQueue);
    }

    public int find(int number) {
        PriorityQueue<Integer> priorityQueue = minIndexMap.get(number);
        if (priorityQueue == null || priorityQueue.isEmpty())
            return -1;
        Integer top = priorityQueue.peek();
        while (number != list.getOrDefault(top, -1)) {
            priorityQueue.poll();
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            top = priorityQueue.peek();
        }
        return top;
    }
}


class NumberContainersTest {
    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();

        numberContainers.change(1, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
        System.out.println(numberContainers.find(20));
        System.out.println(numberContainers.find(30));
    }

}
