package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class ReverseElement {

    public static void reversedArray(int array[]){
//      hum first element ko swap kr rhe last ke sath
//      second element to second last se and so on
        for (int i=0; i<array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
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
        reversedArray(arr);
        for (int value : arr){
            System.out.println(value);
        }
    }
}
