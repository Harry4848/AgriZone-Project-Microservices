package DSA.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 8;

        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            int complement = target - num;

            if (set.contains(complement)){
                System.out.println(complement+" , "+num);
            }
            set.add(num);
        }
    }
}
