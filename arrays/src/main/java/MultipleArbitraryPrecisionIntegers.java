import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleArbitraryPrecisionIntegers {

    /*
     * 6.3 Write a program that takes two arrays representing integers,
     * and returns an integer representing their product.
    */

    public static List<Integer> multiply(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<>();

        if(a.size() < 1 || b.size() < 1) {
            result = null;
        } else if((a.size() == 1 && a.get(0) == 0) || (b.size() == 1 && b.get(0) == 0)) {
            result.add(0, 0);
        } else {
            for (int i = a.size() - 1; i >= 0; i--) {
                int carryOver = 0;
                int carryOverResult = 0;
                int resultIndex = result.size() - a.size() + i;
                for (int j = b.size() - 1; j >= 0; j--) {
                    if(resultIndex < 0) {
                        result.add(0, 0);
                        resultIndex = 0;
                    }
                    int sum = carryOver + Math.abs(a.get(i)) * Math.abs(b.get(j));
                    int resultDigit = (sum % 10 + result.get(resultIndex) + carryOverResult) % 10;
                    carryOver = sum / 10;
                    carryOverResult = (sum % 10 + result.get(resultIndex) + carryOverResult) / 10;

                    result.set(resultIndex, resultDigit);
                    resultIndex--;
                }
                if(carryOver > 0 || carryOverResult > 0) {
                    result.add(0, carryOver + carryOverResult);
                }
            }
            result.set(0, result.get(0) * (a.get(0) * b.get(0)) / Math.abs(a.get(0) * b.get(0)));
        }
        return result;
    }
}
