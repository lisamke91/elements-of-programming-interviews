import java.util.HashMap;

public class RomanToDecimal {

    /*
    7.9
    */

    private static final HashMap<Character, Integer> romanNumerals;

    static{
        romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public static int romanToDecimal(String roman) {
        int decimalValue = 0;

        for(int i = 0; i < roman.length(); i++) {
            char currentLetter = roman.charAt(i++);
            int count = 1;
            while(i < roman.length() && roman.charAt(i) == currentLetter) {
                count++;
                i++;
            }

            if(i > roman.length() - 1
                    || romanNumerals.get(currentLetter) > romanNumerals.get(roman.charAt(i))) {
                decimalValue += count * romanNumerals.get(currentLetter);
                i--;
            } else {
                decimalValue += romanNumerals.get(roman.charAt(i)) - count * romanNumerals.get(currentLetter);
            }
        }

        return decimalValue;
    }
}
