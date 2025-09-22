package solutions.arrays;

import utils.IOUtils;

/* Question: https://leetcode.com/problems/max-consecutive-ones-iii/description/

Approach:
 * Two pointers approach:
 * 1. Use two pointers to keep track of the window of 1s.
 */

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0;
        int zeroCount = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("--- FindMaxConsecutiveOnes ---");
        int[] nums = IOUtils.readIntArray();
        System.out.print("Enter k: ");
        int k = IOUtils.readIntArray()[0];
        MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
        System.out.print("Input: ");
        IOUtils.printArray(nums);
        System.out.println("Result: " + sol.findMaxConsecutiveOnes(nums,k));
    }
}
