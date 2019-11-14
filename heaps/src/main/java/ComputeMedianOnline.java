import java.util.*;

public class ComputeMedianOnline {

    /*
    11.5
    */

    public static List<Double> onlineMedian(Iterator<Integer> sequence) {
        LinkedList<Double> medians = new LinkedList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });

        while(sequence.hasNext()) {
            int value = sequence.next();
            int secondValue;

            if(minHeap.size() == maxHeap.size()) {
                if(minHeap.size() > 0) {
                    secondValue = minHeap.poll();
                    maxHeap.add(Math.min(value, secondValue));
                    minHeap.add(Math.max(value, secondValue));
                } else {
                    maxHeap.add(value);
                }
                medians.add((double) maxHeap.peek());
            } else {
                if(minHeap.size() < maxHeap.size()) {
                    secondValue = maxHeap.poll();
                } else {
                    secondValue = minHeap.poll();
                }
                maxHeap.add(Math.min(value, secondValue));
                minHeap.add(Math.max(value, secondValue));

                medians.add((double) (maxHeap.peek() + minHeap.peek()) / (double) 2);
            }
        }
        return medians;
    }
}
