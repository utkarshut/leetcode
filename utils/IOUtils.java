package utils;

import java.util.*;

public class IOUtils {
    public static int[] readIntArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers (space separated): ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
