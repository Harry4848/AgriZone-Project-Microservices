package StreamAPI;

import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCharacter {
    public static void main(String[] args) {
        String str  = "Collection";

        System.out.println(str.chars().mapToObj(c -> (char) c ).collect(Collectors.groupingBy(Function.identity() , Collectors.counting())));

    }
}
