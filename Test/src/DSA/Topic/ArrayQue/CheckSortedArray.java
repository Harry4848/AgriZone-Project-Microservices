package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class CheckSortedArray {
    public static boolean checkSortedArray(int array[]){
        boolean isSorted = true; // Assume kr liya array sorted h
        for (int i=0; i<array.length-1; i++){ // length-1 nhi likhte to last element ko compare nhi kr paate
            if (array[i]>array[i+1]){
                isSorted = false;
            }
        }
        return isSorted;
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
        System.out.println("Sorted Array = "+checkSortedArray(arr));
    }
}
