package easy;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] sumIndex = new int[2];
        out:
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    sumIndex = new int[]{i, j};
                    break out;
                }
            }
        }
        return sumIndex;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] input = new int[]{-3, 4, 3, 90};
        int target = 0;
        int[] result = ts.twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }
}
