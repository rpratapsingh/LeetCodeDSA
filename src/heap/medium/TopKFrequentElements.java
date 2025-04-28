package heap.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<int[]> topElement = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int[] value = {entry.getKey(), entry.getValue()};
            topElement.offer(value);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topElement.poll()[0];
        }
        return result;
    }
}

class TopKFrequentElementsTest {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, k)));
    }
}
