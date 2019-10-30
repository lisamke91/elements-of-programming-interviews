import java.util.List;

public class PermuteElements {

    /*
     * 6.9 Given an array A of n elements and a permutation P, apply P to A
     *
     * Hint: Any permutation can be viewed as a set of cyclic permutations. For an element in a cycle,
     * how would you identity if it has been permuted?
    */

    public static void applyPermutation(List<Integer> perm, List<Integer> a) {
        int tempValue = 0, tempIndex = -1, currentIndex = 0;
        while(perm.get(currentIndex) != -1) {
            int nextIndex = perm.get(currentIndex);

            if(tempIndex < 0) {
                tempValue = a.get(currentIndex);
                tempIndex = currentIndex;
            }

            if(nextIndex == tempIndex) {
                a.set(currentIndex, tempValue);
                tempIndex = -1;
            } else {
                a.set(currentIndex, a.get(nextIndex));
            }

            perm.set(currentIndex, -1);
            currentIndex = nextIndex;
        }
    }
}
