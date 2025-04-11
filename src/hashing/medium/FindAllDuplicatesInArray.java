package hashing.medium;

import java.util.ArrayList;
import java.util.List;

import static utils.AllUtils.toArray;

public class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(toArray("4,3,2,7,8,2,3,1")));
    }
}
