package DSA.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){
        System.out.println(haveDuplicates());
    }

    public static boolean haveDuplicates(){
        int[] arr = {1,1,2,2,3,3,4};
        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
