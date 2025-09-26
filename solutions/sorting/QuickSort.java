package solutions.sorting;

import java.util.Arrays;

// Approach: Divide and Conquer
// Time Complexity: O(n log n) on average, O(n^2) in the worst case
// Space Complexity: O(log n) due to recursive stack space  
// step1: Choose a pivot element from the array.
// step2: Partition the array into two sub-arrays: elements less than the pivot and
// elements greater than the pivot.
// step3: Recursively apply the above steps to the sub-arrays.
// step4: Combine the sorted sub-arrays and the pivot to get the final sorted array.
// Note: QuickSort is not a stable sort, meaning that it does not preserve the relative order of equal elements.
public class QuickSort {

    int[] nums = { 2, 45, 3, 12, 3, 44, 7, 1 };

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int pivot = nums[(low + high) / 2];
        System.out.println("low :" + low + " high :" + high + " " + pivot);
        int pivotIndex = pivotPartition(nums, low, high, pivot);
        quickSort(nums, low, pivotIndex);
        quickSort(nums, pivotIndex + 1, high);
    }

    // 0 2 45
    // i ->1 j2
    public int pivotPartition(int[] nums, int low, int high, int pivot) {
        int i = low;
        int j = high;
        while (true) {
            while (nums[i] < pivot)
                i++;
            while (nums[j] > pivot)
                j--;
            if (i >= j)
                return j; // pivot boundary found

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        qs.quickSort(qs.nums, 0, qs.nums.length - 1);
        System.out.println(Arrays.toString(qs.nums));
    }
}
