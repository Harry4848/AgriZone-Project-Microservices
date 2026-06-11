package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class OccuranceWord {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Java scala ruby java",
                "Java and java"
        );
        String word = "java";
        System.out.println(list.stream().flatMap(s-> Arrays.stream(s.split(" "))).filter(w->w.equalsIgnoreCase(word)).count());
    }
}
