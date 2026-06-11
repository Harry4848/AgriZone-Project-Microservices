package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class MissingNumber {
    public static void findMissingNumberOneToN(int array[]){
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i];
            int next = array[i + 1];
            while (current + 1 < next) {
                System.out.print(current + 1 + " ");
                current++;
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
        findMissingNumberOneToN(arr);
    }
}
