import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumeratePrimes {

    /*
     * 6.8 Write a program that takes an integer argument and returns all the primes between 1 and that
     * integer. For example,if the input is 18, you should return(2,3,5,7,11,13,17).
     *
     * Hint:Exclude the multiples of primes.
    */

    public static List<Integer> enumeratePrimes(int n) {
        List<Integer> primesList = new ArrayList<>();

        boolean [] isNotPrime = new boolean[n + 1];

        isNotPrime[0] = isNotPrime[1] = true;

        for(int i = 0; i < n/2; i++) {
            if(!isNotPrime[i]) {
                int multiplier = i + i;
                while(multiplier <= n) {
                    isNotPrime[multiplier] = true;
                    multiplier += i;
                }
            }
        }

        for(int j = 0; j < isNotPrime.length -1; j++) {
            if(!isNotPrime[j]) {
                primesList.add(j);
            }
        }

        return primesList;
    }
}
