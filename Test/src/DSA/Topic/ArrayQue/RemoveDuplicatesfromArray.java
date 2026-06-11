package DSA.Topic.ArrayQue;
import java.util.Arrays;
import java.util.Scanner;
// OverAll Time Complexity = O(n log n)
// OverAll Time Complexity = O(log n)
public class RemoveDuplicatesfromArray {
    public static int removeDuplicates(int array[]){
        // O(n) Time Complexity
        // 0(1) Space Complexity
        int uniqueIndex = 0;
        for(int i=1; i<array.length; i++){
            if (array[i] != array[uniqueIndex]){
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }
        return uniqueIndex + 1;
    }
    public static int sortArray(int[] nums) {
        //Time Complexity = O(n log n) because java uses Dual-Pivot QuickSort algorithm to sort
        // Space Complexity = O(log n) because of recursion stack to store
        Arrays.sort(nums);
        return removeDuplicates(nums);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the Elements : ");
        for (int i=0; i<size; i++){
            arr[i]=sc.nextInt();
        }
        int result  = sortArray(arr);
        for (int i = 0; i<result ; i++){// Time Complexity = 0(n)
            System.out.print(arr[i]+" ");
        }
    }
}
