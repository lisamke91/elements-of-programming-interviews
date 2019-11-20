import java.util.List;

public class SearchSortedIndex {

    /*
    12.2
    */

    public static int search(List<Integer> list) {
        return searchHelper(list, 0, list.size() - 1);
    }

    public static int searchHelper(List<Integer> list, int start, int end) {
        // System.out.println("Start: " + start + ", End: " + end);

        if(start >= end) {
            return list.get(start).equals(start) ? start : -1;
        }

        int mid = (start + end) / 2;
        if(mid == list.get(mid)) {
            return mid;
        } else if(mid > list.get(mid)) {
            return searchHelper(list, mid + 1, end);
        } else {
            return searchHelper(list, start, mid - 1);
        }
    }
}
