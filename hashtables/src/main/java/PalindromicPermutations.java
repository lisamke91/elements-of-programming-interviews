import java.util.Hashtable;

public class PalindromicPermutations {

    /*
    13.1
    */

    public static boolean canFormPalindrome(String s) {

        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        int countOdd = 0;

        for(int i = 0; i < s.length(); i++) {
            if(hashtable.containsKey(s.charAt(i))) {
                int charCount = hashtable.get(s.charAt(i));
                if(++charCount % 2 == 0) {
                    countOdd--;
                } else {
                    countOdd++;
                }
                hashtable.put(s.charAt(i), charCount);
            } else {
                hashtable.put(s.charAt(i), 1);
                countOdd++;
            }
        }

        return countOdd < 2;
    }
}
