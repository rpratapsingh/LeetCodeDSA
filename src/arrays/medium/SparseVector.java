package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {

    Map<Integer, Integer> sparse;

    SparseVector(int[] nums) {
        sparse = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sparse.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : sparse.entrySet()) {
            sum += entry.getValue() * vec.sparse.getOrDefault(entry.getKey(), 0);
        }
        return sum;
    }
}


class SparseVectorTest {
    public static void main(String[] args) {

    }
}
