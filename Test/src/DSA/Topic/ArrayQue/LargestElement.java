package DSA.Topic.ArrayQue;
import java.util.Scanner;
public class LargestElement {
    public static int findLargestElement(int array[]){
        // zero index ke element ko hi
        // largest assume kr liya
        int largestElement = array[0];
        for (int i=0; i< array.length; i++){
            // ab hamare assume element se koi
            // elemnt bada h to hamare element ko
            // remove kr do aur tumhara element daal do
            if(array[i]>largestElement){
                largestElement=array[i];
            }
        }
        return largestElement;
    }
    public static int findSecondLargestElement(int array[]){
        int largestElement = array[0]; // Assume 0 index wala hi largest h
        int secondLargestElement = array[1]; // Assume 1 index wala hi second largest h
        for (int i=0; i<array.length; i++){
            if (array[i]>largestElement){ // i index wala element agar largest se bada h to
                secondLargestElement = largestElement; // largest element ko second largest me daal do
                largestElement = array[i]; // i index wale element ko largest element me daal do
            } else if (array[i]>secondLargestElement && array[i]!=largestElement) { // i index wala element agar second largest se bada h or largest element ke equal na ho to
                secondLargestElement = array[i]; // i index wale element ko second largest me daal do
            }
        }
        return secondLargestElement;
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
        System.out.println("Largest Element : "+findLargestElement(arr));
        System.out.println("Second Largest Element : "+findSecondLargestElement(arr));
    }
}
