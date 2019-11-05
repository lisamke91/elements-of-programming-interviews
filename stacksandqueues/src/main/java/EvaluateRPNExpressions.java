import java.util.LinkedList;

public class EvaluateRPNExpressions {

    /*
     * 9.2 Write a program that takes an arithmetical expression in RPN and returns
     * the number that the expression evaluates to.
    */

    public static Integer eval(String RPNExpression) {
        String [] strings = RPNExpression.split(",");
        return evaluateExpression(strings, new LinkedList<Integer>(), 0);
    }

    private static Integer evaluateExpression(String [] strings, LinkedList<Integer> stack, int index) {
        int number = 0;
        boolean isNumber;
        // determine if number or operation
        try {
            number = Integer.parseInt(strings[index]);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }

        if(index == strings.length - 1) {
            // base case
            if(isNumber) {
                return number;
            } else {
                return calculate(strings[index], stack.pop(), stack.pop());
            }
        } else {
            // recursive case
            if(isNumber) {
                stack.push(number);
            } else {
                stack.push(calculate(strings[index], stack.pop(), stack. pop()));
            }
            return evaluateExpression(strings, stack, index + 1);
        }
    }

    private static Integer calculate(String s, int a, int b) {
        if(s.equals("-")) {
            return b - a;
        } else if(s.equals("+")) {
            return b + a;
        } else if(s.equals("x")) {
            return b * a;
        } else if(s.equals("/")) {
            return b / a;
        }
        return null;
    }
}
