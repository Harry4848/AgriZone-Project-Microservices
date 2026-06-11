package DSA.LeetCode;

public class ZerosLeft {

    // Two Pointer Approach O(n)
    public static void main(String[] args) {

        int[] arr = {8,0,9,11,13,0,15,17,0,19};
        int left = 0;
        int right = arr.length-1;

        while(left < right){

            while(arr[left]!=0 && left<right){
                left++;
            }
            while(arr[right] ==0 && left<right){
                right--;
            }

            if(left < right){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        for(int num : arr){
            System.out.print(num + " ");
        }

    }

}
