package DSA.LeetCode;

import java.util.Arrays;

public class ZeroesRight {
    public static void main(String[] args) {
        int[] arr = {8,0,9,11,13,0,15,17,0,19};

        // 'index' will track position where next non-zero element should be placed
        int index = 0;

        // Loop through entire array
        for (int i = 0; i < arr.length; i++) {

            // Check if current element is non-zero
            if (arr[i] != 0) {

                // Place non-zero element at 'index' position
                arr[index] = arr[i];

                // Move index forward for next non-zero element
                index++;
            }
        }

        // After placing all non-zero elements,
        // fill remaining positions with 0
        while (index < arr.length) {

            // Put 0 at current index
            arr[index] = 0;

            // Move index forward
            index++;
        }

        // Print final array after moving all zeros to right
        System.out.println(Arrays.toString(arr));
    }
}
