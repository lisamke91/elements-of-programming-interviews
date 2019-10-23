import java.util.Random;

public class GenerateUniformRandomNumbers {

    /*
     * 5.10 How would you implement a random number generator that generates a random number
     * i between a and b, inclusive, given a random number generator that produces 0 or 1 with
     * equal probability?
    */

    private static final int ADJUSTED_LOWER_BOUND = 0;

    public static int uniformRandom(int lowerBound, int upperBound) {
        Random random = new Random();

        int adjustedUpperBound = upperBound - lowerBound;
        int numBinDigits = log2(adjustedUpperBound) + 1;

        int result = -1;
        // iterate through number of binary digits
        while(result < ADJUSTED_LOWER_BOUND || result > adjustedUpperBound) {
            int tempResult = 0;
            for (int i = ADJUSTED_LOWER_BOUND; i < numBinDigits; i++) {
                // generate random bin digit & add to result
                tempResult += random.nextInt(2) << i;
            }
            result = tempResult;
        }
        return (result + lowerBound);
    }

    private static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
