import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ComputeMnemonicsPhoneNumberTest {

    private List<String> expectedResults;
    private String phoneNumber;

    @Test
    public void computeMnemonics1() {
        phoneNumber = "2276696";
        expectedResults = Arrays.asList("ACRONYM", "ABPOMZN");

        test(expectedResults, phoneNumber);
    }

    @Test
    public void computeMnemonics2() {
        phoneNumber = "5387739";
        expectedResults = Arrays.asList("JETPREY", "LETSSEX", "JETSPEW");

        test(expectedResults, phoneNumber);
    }

    @Test
    public void computeMnemonics3() {
        phoneNumber = "234";
        expectedResults = Arrays.asList("ADG");

        test(expectedResults, phoneNumber);
    }

    private void test(List<String> expectedResults, String phoneNumber) {
        List<String> actualResults = ComputeMnemonicsPhoneNumber.computeMnemonics(phoneNumber);

        assertEquals(numberSequences(phoneNumber), actualResults.size());

        //System.out.println(actualResults.toString());

        for (String mnemonic : expectedResults) {
            assertTrue(actualResults.contains(mnemonic));
        }
    }

    private int numberSequences(String s) {
        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            count *= getLetterCount(s.charAt(i));
        }
        return count;
    }

    private int getLetterCount(char c) {
        if(c == '7'|| c == '9') {
            return 4;
        }
        return 3;
    }

}