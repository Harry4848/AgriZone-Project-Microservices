package StreamAPI;

import java.util.Arrays;
import java.util.stream.Collectors;
public class FrequencyWord {

    public static void main(String[] args) {
        String s = "java spring Java SPRING boot BooT";

        // "We convert the string into a stream, normalize words to lowercase, then group them using groupingBy and count occurrences using counting() collector."

        System.out.println(Arrays.stream(s.split(" ")).map(word -> word.toLowerCase()).collect(Collectors.groupingBy(word -> word , Collectors.counting())));
        System.out.println(Arrays.stream(s.split(" ")).map(word -> word.toLowerCase()).collect(Collectors.groupingBy(word -> word , Collectors.counting())));
        System.out.println(Arrays.stream(s.split(" ")).map(word -> word.toLowerCase()).collect(Collectors.groupingBy(word -> word , Collectors.counting())));
    }
}
