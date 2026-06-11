package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class SumArray {
public static int sumArray(int array[]) {
    int sum = 0;
    for(int i = 0; i <array.length; i++){
        sum += array[i];
    }
    return sum;


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
        System.out.println(sumArray(arr));
    }

}
