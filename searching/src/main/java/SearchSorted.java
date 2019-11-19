import java.util.ArrayList;
import java.util.List;

public class SearchSorted {

    /*
    12.1
    */

    public static int search(List<Integer> list, int k) {
        return searchHelper(new ArrayList<>(list), k, list.size() / 2,
                0, list.size() - 1, false);
    }

    // recursive search
    public static int searchHelper(ArrayList<Integer> list, int k, int mid,
                                   int startIndex, int endIndex, boolean valueFound) {
        // System.out.println("StartIndex: " + startIndex + ", EndIndex: " + endIndex + ", MidIndex: " + mid);
        if(!valueFound) {
            valueFound = mid == k;
        }

        if(valueFound && isFirstOccurrence(list, mid)) {
            return mid;
        } else {
            if(startIndex == endIndex)  {
                return -1;
            } else {
                int newStart, newMid, newEnd;
                if (traverseRight(list, k, mid, valueFound)) {
                    newStart = mid + 1;
                    newEnd = endIndex;
                } else {
                    newStart = startIndex;
                    newEnd = mid - 1;
                }
                newMid = (newEnd + newStart) / 2;
                return searchHelper(list, k, newMid, newStart, newEnd, valueFound);
            }
        }
    }

    private static boolean traverseRight(ArrayList<Integer> list, int k, int mid, boolean valueFound) {
        return (valueFound && !list.get(mid).equals(k)) || (!valueFound && list.get(mid) < k);
    }

    // determine if first occurrence
    private static boolean isFirstOccurrence(ArrayList<Integer> list, int index) {
        return index == 0 || !list.get(index - 1).equals(index);
    }
}
