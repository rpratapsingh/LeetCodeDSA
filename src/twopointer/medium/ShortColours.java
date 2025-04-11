// https://leetcode.com/problems/sort-colors/description/

package twopointer.medium;

import java.util.Arrays;

import static utils.AllUtils.toArray;

public class ShortColours {
    public static void sortColors(int[] nums) {

        int redPointer = 0, bluePointer = nums.length - 1, whitePointer = 0;
        while (whitePointer <= bluePointer) {
            if (nums[whitePointer] == 0) {
                int temp = nums[redPointer];
                nums[redPointer] = nums[whitePointer];
                nums[whitePointer] = temp;
                whitePointer++;
                redPointer++;
            } else if(nums[whitePointer] == 1){
                whitePointer++;
            }
            else{
                int temp = nums[bluePointer];
                nums[bluePointer] = nums[whitePointer];
                nums[whitePointer] = temp;
                bluePointer--;
            }
        }
        //System.out.println(redPointer + " " + movingPointer);
    }


    public static void main(String[] args) {
        int[] nums = toArray("2,0,2,1,1,0");
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
