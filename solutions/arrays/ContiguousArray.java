package solutions.arrays;

/* Question: https://leetcode.com/problems/contiguous-array/
Need to find the longest subarray with equal number of 0s and 1s.

Approach:
1. Convert all 0s to -1s.
2. Use a prefix sum to find the longest subarray with equal number of 0s and 1s.
3. Use a hashmap to store the prefix sum and the index of the first occurrence of the prefix 
   sum.
4. If the prefix sum is already in the hashmap, then the subarray from the index of the 
   first occurrence of the prefix sum to the current index is the longest subarray with 
   equal number of 0s and 1s. */


import utils.IOUtils;
import java.util.*;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int prefixSum = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
            prefixSum += nums[i];

            if (map.containsKey(prefixSum)) {
                res = Math.max(res, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("--- FindMaxLength ---");
        int[] nums = IOUtils.readIntArray();
        ContiguousArray sol = new ContiguousArray();
        System.out.print("Input: ");
        IOUtils.printArray(nums);
        System.out.println("Result: " + sol.findMaxLength(nums));
    }
}
