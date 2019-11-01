public class PalindromeAlphanumeric {

    /*
     * 7.5 Implement a function that takes as input a string s and returns true if s is a palindrome
    */

    public static boolean isPalindrome(String input) {
        boolean isPalindrome = true;

        String trimString = trimString(input.toUpperCase());

        for(int i = 0; i < trimString.length() / 2; i++) {
            if(trimString.charAt(i) != trimString.charAt(trimString.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    private static String trimString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if((currentChar <= 'Z' && currentChar >= 'A')
                    || (currentChar >= '0' && currentChar <= '9')) {
                stringBuilder.append(currentChar);
            }
        }
        return stringBuilder.toString();
    }
}
