public class CheckIfIntegerIsPalindrome {

    /*
     * 5.9 Write a program that takes an integer and determines if that integer'srepresentation as a decimal string is a palindrome.
     *
     * Hint: It's easy to come up with a simple expression that extracts the least significant digit.
     * Can you find a simple expression for the most significant digit?
    */

    public static boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        int currentNumber = x, lsd, msd, numDigits;

        numDigits = getNumDigits(x);

        // a negative input value cannot be a palindrome
        if(x < 0) {
            isPalindrome = false;
        }

        while(currentNumber != 0 && isPalindrome) {
            // extract least significant digit
            lsd = currentNumber % 10;
            currentNumber /= 10;

            // if value is not 0, extract the most significant digit
            if(currentNumber != 0) {
                msd = currentNumber / (int) Math.pow(10, numDigits - 1);
                currentNumber %= Math.pow(10, numDigits - 1);

                // compare msd and lsd
                if(msd != lsd) {
                    isPalindrome = false;
                }
            }
        }

        return isPalindrome;
    }

    private static int getNumDigits(int num) {
        return (int) (Math.log10(num) + 1);
    }
}
