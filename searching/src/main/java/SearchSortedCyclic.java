import java.util.List;

public class SearchSortedCyclic {

    /*
    12.3
    */

    public static int search(List<Integer> list) {
        return searchHelper(list, 0, list.size() - 1);
    }

    private static int searchHelper(List<Integer> list, int start, int end) {
        if(end == start) {
            return start;
        }

        if(list.get(start) < list.get(end)) {
            return start;
        } else {
            int leftMinIndex = searchHelper(list, start, (end + start) / 2);
            int rightMinIndex = searchHelper(list, (end + start) / 2 + 1, end);
            if(list.get(leftMinIndex) < list.get(rightMinIndex)) {
                return leftMinIndex;
            } else {
                return rightMinIndex;
            }
        }
    }
}
