package DSA.LeetCode;

public class StringConversion {
    public static void main(String[] args) {
        String input = "hElLo"; // Input string whose case we want to toggle

        StringBuilder result = new StringBuilder();
        // StringBuilder is used to efficiently build the output string

        for (char ch : input.toCharArray()) {
            // Convert string to char array and iterate over each character

            if (Character.isLowerCase(ch)) {
                // Check if the character is lowercase

                result.append(Character.toUpperCase(ch));
                // Convert lowercase to uppercase and append to result

            } else if (Character.isUpperCase(ch)) {
                // Check if the character is uppercase

                result.append(Character.toLowerCase(ch));
                // Convert uppercase to lowercase and append to result

            } else {
                result.append(ch);
                // If character is not a letter (e.g., number, symbol), append as it is
            }
        }

        System.out.println("Output: " + result.toString());
        // Print the final toggled string
    }
}
