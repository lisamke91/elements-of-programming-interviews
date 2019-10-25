import java.util.List;

public class IncrementArbitraryPrecisionInteger {

    /*
     * 6.2 Write a program which takes as input an array of digits encoding a decimal number D
     * and updates the array to represent the number D + 1.
     *
     * For example, if the input is (1,2,9) then you should update the array to (1,3,0).
     * Your algorithm should work even if it is implemented in a language that has finite-precision arithmetic.
     *
     * Hint:Experiment withconcreteexamples.
    */

    public static List<Integer> incrementInteger(List<Integer> A) {
        int carryOver = 1, index = A.size() - 1;
        while(carryOver == 1 && index >= 0) {
            int value = A.get(index);
            if(value < 9) {
                A.set(index, value + 1);
                carryOver = 0;
            } else {
                A.set(index, 0);
            }
            index--;
        }

        if(carryOver == 1) {
            A.add(0, 1);
        }

        return A;
    }
}
