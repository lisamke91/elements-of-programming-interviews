public class InterconvertStringAndInteger {

    /*
     * 7.1 Implement string/integer inter-conversion functions.
     *
     * Hint: Build the result one digit at a time.
    */

    private static final int TEN = 10;

    public static Integer stringToInt(String number) {
        int intRep = 0;
        for(int i = 1; i <= number.length(); i++) {
            char value = number.charAt(number.length() - i);
            if(value == '-') {
                intRep *= -1;
            } else {
                intRep += (value - '0') * Math.pow(TEN, i - 1);
            }
        }
        return intRep;
    }

    public static String intToString(Integer number) {
        StringBuilder resultString = new StringBuilder();
        int posNum = Math.abs(number);

        if(number == 0) {
            resultString.append('0');
        }

        while(posNum > 0) {
            int digit = posNum % TEN;
            resultString.insert(0, (char) (digit + '0'));
            posNum /= TEN;
        }

        if(number != 0 && number / Math.abs(number) < 0) {
            resultString.insert(0, '-');
        }

        return resultString.toString();
    }

}
