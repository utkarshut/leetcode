package solutions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Bucket sort based on frequencies
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Collecting top k frequent elements
        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[index++] = num;
                    if (index == k)
                        break;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
