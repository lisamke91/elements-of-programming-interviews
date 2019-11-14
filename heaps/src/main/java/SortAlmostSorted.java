import java.util.*;

public class SortAlmostSorted {

    /*
    11.3
    */

    public static List sort(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        LinkedList<Integer> sortedItems = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            minHeap.add(sequence.next());
        }

        // extract next item, compare, and add next list item
        while(sequence.hasNext()) {
            int currentItem = sequence.next();
            if(minHeap.size() > 0 && currentItem > minHeap.peek()) {
                minHeap.add(currentItem);
                currentItem = minHeap.poll();
            }
            sortedItems.add(currentItem);
        }

        // add remaining heap items, if any
        while(minHeap.size() > 0) {
            sortedItems.add(minHeap.poll());
        }

        return sortedItems;
    }

}
