package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class MaximumValue {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 42, 36, 54, 35);

        //Using method reference ::
        System.out.println(list.stream().max(Integer::compare).get());

        //Using lambda Expression ()->
        System.out.println(list.stream().max((a, b) -> a.compareTo(b)).get());
    }
}
