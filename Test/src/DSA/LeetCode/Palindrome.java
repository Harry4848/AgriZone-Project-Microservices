package DSA.LeetCode;

public class Palindrome {
    public static void main(String[] args) {
        String str = "nitin"; // madam , bob ,

        boolean isPalindrome = true;

        int start = 0;
        int end = str.length()-1;

        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                isPalindrome = false;
                break;
            }
            start++;
            end--;

        }
        if(isPalindrome){
            System.out.println("yes it is palindrome");
        }else {
            System.out.println("No it is not palindrome");
        }
    }
}
