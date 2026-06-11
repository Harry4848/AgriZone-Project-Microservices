package DSA.Topic.ArrayQue;

import java.util.Scanner;

public class CountTargetElement {
    public static int countTargetElement(int array[] , int targetElement){
        int count = 0;
        for (int i=0; i<array.length; i++){
            // jo bhi element h agar bo target elemnt se match
            // kr rha h to simply uska count increase kr do
            if (array[i]==targetElement){
                count++;
            }
        }
        return count;
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
        System.out.println("Enter Target Element");
        int target = sc.nextInt();

        System.out.println("Count = "+countTargetElement(arr,target));
    }
}
