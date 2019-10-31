public class SpreadsheetColumnEncoding {

    /*
     * 7.3 Implement a function that converts a spreadsheet column id to the corresponding integer,
     * with "A" corresponding to 1.
    */

    public static int decodeSpreadsheetColumn(String code) {
        int integerRep = 0;

        for(int i = 0; i < code.length(); i++) {
            integerRep += (code.charAt(i) - 'A' + 1) * Math.pow(26, i);
        }

        return integerRep;
    }


}
