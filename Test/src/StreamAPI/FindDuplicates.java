package StreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicates  {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,2,2,3,3,4,4,5,6,7);
        System.out.println(list.stream().filter(n-> Collections.frequency(list, n)>1).distinct().collect(Collectors.toList()));
    }
}
