import java.util.*;

public class ComputeMnemonicsPhoneNumber {

    /*
     * 7.7
    */

    private static final Map<Character, String> phoneLetterMap;
    static {
        phoneLetterMap = new HashMap<>();
        phoneLetterMap.put('2', "ABC");
        phoneLetterMap.put('3', "DEF");
        phoneLetterMap.put('4', "GHI");
        phoneLetterMap.put('5', "JKL");
        phoneLetterMap.put('6', "MNO");
        phoneLetterMap.put('7', "PQRS");
        phoneLetterMap.put('8', "TUV");
        phoneLetterMap.put('9', "WXYZ");
    }

    public static List<String> computeMnemonics(String phoneNumber) {
        List<String> sequences = new ArrayList<>();
        char [] result = new char[phoneNumber.length()];
        recursiveCall(0, phoneNumber, sequences, result);
        return sequences;
    }

    private static void recursiveCall(int index, String phoneNumber, List<String> sequences, char [] resultString) {
        String letterOptions = phoneLetterMap.get(phoneNumber.charAt(index));
        for(int j = 0; j < letterOptions.length(); j++) {
            resultString[index] = letterOptions.charAt(j);
            if(index == phoneNumber.length() - 1) {
                sequences.add(new String(resultString));
            } else {
                recursiveCall(index + 1, phoneNumber, sequences, resultString);
            }
        }
    }

}
