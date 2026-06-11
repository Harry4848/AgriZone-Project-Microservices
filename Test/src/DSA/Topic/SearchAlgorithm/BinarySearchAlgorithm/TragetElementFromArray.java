package DSA.Topic.SearchAlgorithm.BinarySearchAlgorithm;
import java.util.Arrays;
import java.util.Scanner;
// Binary search algorithm efficient tab hi h jab array already sorted ho
// array sorted nhi h isiliye hum beech me ek method sort krne ki daal rhe khud se
// binary search me comparison kam gonge kyunki hum har baar adhe ignor kr rhe h
public class TragetElementFromArray {
    public static int findTargetElement(int array[], int targetElement){
        int low = 0;
        int high = array.length-1;
        int i =1;
        while (low<=high){
            System.out.println("Pass"+i);// sirf check kr rhe h kitni baar me element mila
            i++;// check krne wali ye do line ko hata bhi sakte h
            int midIndex = low+(high-low)/2;
            if (array[midIndex]==targetElement){
                return midIndex;
            }
            if (targetElement<array[midIndex]){
                high = midIndex-1;
            }
            if (targetElement>array[midIndex]){
                low = midIndex+1;
            }
        }
        return -1;
    }
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
    public static int[] sortArray(int[] nums) {
        //Time Complexity = O(n log n) because java uses Dual-Pivot QuickSort algorithm to sort
        // Space Complexity = O(log n) because of recursion stack to store
        Arrays.sort(nums);
        int uniqueSize = removeDuplicates(nums);
        int[] uniqueArray = new int[uniqueSize];// new array banai h unique elements ki
        for (int i = 0; i < uniqueSize; i++) {
            uniqueArray[i] = nums[i];
        }
        return uniqueArray;
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
        int[] uniqueArray = sortArray(arr);
        for (int num : uniqueArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Enter Target Element");
        int targetElement = sc.nextInt();
        System.out.println("Index = "+ findTargetElement(uniqueArray,targetElement));
    }
}
