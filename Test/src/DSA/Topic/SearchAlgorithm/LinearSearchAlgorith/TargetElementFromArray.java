package DSA.Topic.SearchAlgorithm.LinearSearchAlgorith;
import java.util.Scanner;
// linear search har element pr jaa kar search kr rha h target element ko
//
public class TargetElementFromArray {
    public static int findTragetElement(int array[], int targetElement){
        int index = -1;
        for (int i=0; i<array.length; i++){
            if (array[i]==targetElement){
                index = i;
                break;
            }
        }
        return index;
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
        int targetElement = sc.nextInt();
        System.out.println("Index = "+findTragetElement(arr,targetElement));
    }
}