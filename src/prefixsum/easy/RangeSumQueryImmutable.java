// https://leetcode.com/problems/range-sum-query-immutable/description/

package prefixsum.easy;

public class RangeSumQueryImmutable {

    int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = new int[nums.length];
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            this.nums[index] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return nums[right];
        return nums[right] - nums[left - 1];
    }

    public static void main(String[] args) {

        int[] array = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(array);
        System.out.println(rangeSumQueryImmutable.sumRange(0, 2));
        System.out.println(rangeSumQueryImmutable.sumRange(2, 5));
        System.out.println(rangeSumQueryImmutable.sumRange(0, 5));
    }
}
