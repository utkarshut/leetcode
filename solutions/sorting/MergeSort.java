package solutions.sorting;

import java.util.Arrays;

// Approach:
// divide till single item found then recursively add merge to 
// other part like left [2,4] right [3, 6]
// each item from right to left compare then add to temp array
// if any one item array exhausted end of while loop 
// then merge the remaining array by while loop
// finally replace item in original array using index
public class MergeSort {
    public void mergeSort(int[] arr, int l, int r){
        if(l==r) return;
        int m = (r+l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr,l,m,r);
    }
    public void merge(int arr[], int l, int m , int r){
         int left = l;  // intialize from l
         int right = m+1;  // 
         int[] temp = new int[r-l+1]; 
         int idx = 0;
         while(left<=m && right<=r){
            if(arr[left]<= arr[right]){
                temp[idx++]= arr[left++];
            }else{
                temp[idx++]= arr[right++];
            }
         }
         while(left <= m){
            temp[idx++]= arr[left++];
         }
         while(right <= r){
            temp[idx++]= arr[right++];
         }
         for(int i = 0; i < temp.length; i++){
            arr[l+i]= temp[i]; // l + i  since   it can send from arr e,g, 3->5 
         }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,44,5,3,667,73,2,1,3};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length-1);
        System.err.println(Arrays.toString(arr));
    }
}
