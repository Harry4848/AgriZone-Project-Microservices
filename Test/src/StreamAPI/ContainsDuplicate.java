package StreamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){
        System.out.println(getDuplicates());
    }
    public static boolean getDuplicates() {
        int[] arr = {1, 2, 1, 2, 3, 4, 5};
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(arr)
                .anyMatch(num -> !set.add(num));
    }
}
