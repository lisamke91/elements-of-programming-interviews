import java.util.LinkedList;

public class IsStringWellFormed {

    /*
     * 9.3 Writea program that tests if a string made up of the characters'(',')','[',
     * and"}' is well-formed.
    */

    public static boolean isWellFormed(String s) {
        String [] brackets = s.split("");
        LinkedList<String> openBrackets = new LinkedList<>();
        boolean isWellFormed = true;
        int index = 0;

        while(index < brackets.length && isWellFormed) {
            if(isOpenBracket(brackets[index])) {
                openBrackets.push(brackets[index]);
            } else {
                isWellFormed = openBrackets.size() > 0 && isMatchingBracket(openBrackets.pop(), brackets[index]);
            }
            index++;
        }

        return isWellFormed && openBrackets.size() == 0;
    }

    private static boolean isOpenBracket(String s) {
        return s.equals("{") || s.equals("[") || s.equals("(");
    }

    private static boolean isMatchingBracket(String openBracket, String closedBracket) {
        switch (openBracket) {
            case "{":
                return closedBracket.equals("}");
            case "[":
                return closedBracket.equals("]");
            case "(":
                return closedBracket.equals(")");
            default:
                return false;
        }
    }
}
