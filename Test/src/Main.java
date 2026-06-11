import java.util.Scanner;
public class Main {
    public static void rotateArray(int array[], int k){
        // reversive algorithm
        int n = array.length;
        k = k%n;
        // reverse whole array
        for (int start=0, end = n-1; start<end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // reverse k elements
        for (int start=0, end = k-1; start<end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // reverse remaining elements
        for (int start=k, end = n-1; start<end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("enter the elements");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter k ");
        int k = sc.nextInt();
        rotateArray(arr,k);
        for (int num : arr){
            System.out.print(num+ " ");
        }
    }
}
