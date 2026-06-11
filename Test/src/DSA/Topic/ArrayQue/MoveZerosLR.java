package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class MoveZerosLR {
    public static void moveZerosRight(int array[]) {
        int right = 0;
        for (int left = 0; right < array.length; right++) {
            if (array[right] != 0) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
            }
        }
    }
    public static void moveZerosLeft(int array[]){
        int right = array.length-1;
        for (int left = array.length-1; left >=0; left--) {
            if (array[left] != 0) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                right--;
            }
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
        moveZerosRight(arr);
        for (int num: arr){
            System.out.print(num+" , ");
        }
        System.out.println();
        moveZerosLeft(arr);
        for (int num: arr){
            System.out.print(num+" , ");
        }
    }
}
