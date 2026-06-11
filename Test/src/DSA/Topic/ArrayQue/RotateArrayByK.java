package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class RotateArrayByK {
    public static void rotateArray(int array[],int k){
        int n = array.length;
        k = k % n;
        // Reverse whole array
        for (int start = 0, end = n - 1; start < end; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // Reverse first k elements
        for (int start = 0, end = k - 1; start < end; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // Reverse remaining elements
        for (int start = k, end = n - 1; start < end; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
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
        System.out.print("Enter K: ");
        int k = sc.nextInt();
        rotateArray(arr, k);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
