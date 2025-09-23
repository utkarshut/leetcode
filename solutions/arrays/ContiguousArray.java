package solutions.arrays;

/* 
Question: https://leetcode.com/problems/contiguous-array/
Need to find the longest subarray with equal number of 0s and 1s.

Approach:
1. Convert all 0s to -1s.
2. Use a prefix sum to find the longest subarray with equal number of 0s and 1s.
3. Use a hashmap to store the prefix sum and the index of the first occurrence of the prefix 
   sum.
4. If the prefix sum is already in the hashmap, then the subarray from the index of the 
   first occurrence of the prefix sum to the current index is the longest subarray with 
   equal number of 0s and 1s. 
*/
/* 
LEARNINGS:
Transforming Input Data: 
The transformation of 0s to -1s is a clever trick that simplifies the problem.
By converting the problem into finding subarrays with a sum of 0, we can leverage the prefix sum technique more effectively.
Edge Case Handling: 
Initializing the HashMap with a prefix sum of 0 at index -1 is an important step. 
Time Complexity: 
The solution runs in O(n) time complexity, 
Space Complexity: 
The space complexity is O(n) in the worst case due to the HashMap storing prefix sums.
Practical Application: 
This approach can be applied to other similar problems involving subarrays and equal distributions of 
elements, making it a versatile technique in algorithm design.   
*/

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

