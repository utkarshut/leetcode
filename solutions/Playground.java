package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playground {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5 };

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new ArrayList[arr.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key); 
        }
        int k = 3;
        int[] res = new int[k];
        int index = 0;
        for(int i=buckets.length-1; i>=0 && index<k; i--) {
            if(buckets[i] != null) {
                for(int num : buckets[i]) {
                    res[index++] = num;
                    if(index==k) break;
                }
            }
        }   
    }
}
