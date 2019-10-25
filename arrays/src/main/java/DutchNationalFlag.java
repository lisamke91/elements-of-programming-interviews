import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {

    /*
     * 6.1 Write a program that takes an array A and an index i into A, and rearranges the
     * element ssuch that all elements less than A[i] (the "pivot") appear first,
     * followed by element sequel to the pivot,followed by elements greater than the pivot.
     *
     * Hint:Think about the partition step in quicksort.
    */

    public static void dutchNationalFlag(int p, List<Integer> A) {
        /*
         * bottom: [0, firstMiddle - 1]
         * middle: [firstMiddle, firstTopIndex]
         * top: [firstTopIndex, A.size() - 1]
         * unclassified: [currentIndex, firstTopIndex]
         */
        int currentIndex = 0, firstTopIndex = A.size() - 1, lastBottomIndex = 0;
        int pivotValue = A.get(p);

        while(currentIndex < firstTopIndex) {
            if(A.get(currentIndex) < pivotValue) {
                Collections.swap(A, currentIndex, lastBottomIndex);
                currentIndex++;
                lastBottomIndex++;
            } else if(A.get(currentIndex) > pivotValue) {
                Collections.swap(A, currentIndex, firstTopIndex);
                firstTopIndex--;
            } else {
                currentIndex++;
            }
        }
    }
}
