package StreamAPI;

import java.util.stream.Collectors;

public class StringConversion {
    public static void main(String[] args) {
        String input = "hElLo";
        String result = input.chars()
                .mapToObj(c -> (char) c)
                .map(ch -> Character.isLowerCase(ch)
                        ? Character.toUpperCase(ch)
                        : Character.isUpperCase(ch)
                        ? Character.toLowerCase(ch)
                        : ch)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
