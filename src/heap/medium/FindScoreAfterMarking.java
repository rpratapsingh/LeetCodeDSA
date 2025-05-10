package heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindScoreAfterMarking {

    public long findScore(int[] nums) {
        int length = nums.length;
        int[][] sortedOrder = new int[length][2];
        long sum = 0;
        for (int i = 0; i < length; i++) {
            sortedOrder[i] = new int[]{nums[i], i};
        }
        Arrays.sort(sortedOrder, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < length; i++) {
            int[] top = sortedOrder[i];
            int index = top[1];
            if(nums[index] == -1)
                continue;
            sum += top[0];
            nums[index] = -1;
            if (index - 1 >= 0 && nums[index - 1] != -1) {
                nums[index - 1] = -1;
            }
            if (index + 1 < length && nums[index + 1] != -1) {
                nums[index + 1] = -1;
            }
        }
        return sum;
    }
}

class FindScoreAfterMarkingTest {
    public static void main(String[] args) {
        int[] input = {10, 44, 10, 8, 48, 30, 17, 38, 41, 27, 16, 33, 45, 45, 34, 30, 22, 3, 42, 42};
        FindScoreAfterMarking findScoreAfterMarking = new FindScoreAfterMarking();
        System.out.println(findScoreAfterMarking.findScore(input));
    }
}
