public class BaseConversion {

    /*
     * 7.2 Write a program that performs base conversion
     *
     * Hint: What base can you easily convert to and from?
    */

    public static String baseConversion(String s, int b1, int b2) {

        // convert to base 10
        int number = convertToBase10(s, b1);
        return convertToBase(number, b2);
    }

    private static int convertToBase10(String s, int base) {
        int base10Number = 0;
        boolean isNegative = s.charAt(0) == '-';

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(s.length() - i - 1) != '-') {
                base10Number += convertCharToInt(s.charAt(s.length() - i - 1)) * Math.pow(base, i);
            }
        }

        return base10Number * (isNegative ? -1 : 1);
    }

    private static String convertToBase(int base10Number, int base) {
        StringBuilder stringBuilder = new StringBuilder();

        boolean isNeg = base10Number < 0;
        base10Number = Math.abs(base10Number);

        while(base10Number > 0) {
            int digit = base10Number % base;
            stringBuilder.insert(0, convertToChar(digit));
            base10Number /= base;
        }

        if(isNeg) {
            stringBuilder.insert(0, '-');
        }

        return  stringBuilder.toString();
    }

    private static int convertCharToInt(char c) {
        if(Math.abs('9' - c) < 10) {
            return c - '0';
        } else {
            return 10 + c - 'A';
        }
    }

    private static char convertToChar(int digit) {
        if(digit < 10) {
            return (char) (digit + '0');
        } else {
            return (char) (digit - 10 + 'A');
        }
    }
}
