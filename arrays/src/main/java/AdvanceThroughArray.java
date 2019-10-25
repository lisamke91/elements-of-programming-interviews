import java.util.List;

public class AdvanceThroughArray {

    /*
     * 6.4 Write a program which takes an array of n integers,
     * whereA[i] denotes the maximum you can advance from index i,
     * and returns whether it is possible to advance to the last
     * index starting from the beginning of thearray.
     *
     * Hint:Analyze each location, starting from the beginning.
    */

    public static boolean arrayAdvance(List<Integer> A) {
        boolean successfulAdvance = false;
        int maxAdv = 1;
        int index = 0;

        while(!successfulAdvance && maxAdv > 0 && index < A.size()) {
            maxAdv--;
            maxAdv = Math.max(A.get(index), maxAdv);
            if(index == A.size() - 1) {
                successfulAdvance = true;
            }
            index++;
        }

        return successfulAdvance;
    }
}
