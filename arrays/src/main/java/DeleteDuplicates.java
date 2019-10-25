import java.util.List;

public class DeleteDuplicates {

    /*
     * 6.5 Write a program which takes as input a sorted array and updates it so that all
     * duplicates have been removed and the remaining elements have been shifted left
     * to fill the emptied indices. Return the number of valid elements. Many languages have library
     * functions for performing this operation — you cannot use these functions.
     *
     * Hint:There is an 0(n) time and 0(1) space solution.
    */

    public static int deleteDuplicates(List<Integer> A)
    {
        int nextAvailSpace = 1, currentIndex = 1, prevValue = A.get(0);
        int elements = A.size() < 1 ? 0 : 1;

        while(currentIndex < A.size()) {
            int currentValue = A.get(currentIndex);
            A.set(currentIndex, null);
            if(currentValue != prevValue) {
                A.set(nextAvailSpace, currentValue);
                prevValue = currentValue;
                nextAvailSpace++;
                elements++;
            }
            currentIndex++;
        }

        return elements;
    }
}
