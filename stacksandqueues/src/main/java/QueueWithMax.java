import java.util.Deque;
import java.util.LinkedList;

public class QueueWithMax {

    /*
    9.10
    */

    private Deque<Integer> maxValues = new LinkedList<>();
    private Deque<Integer> queue = new LinkedList<>();

    public void enqueue(Integer x) {
        queue.add(x);
        if(maxValues.size() == 0 || x <= maxValues.getLast()) {
            maxValues.addLast(x);
        } else {
            while(maxValues.size() > 0 && x > maxValues.getLast()) {
                maxValues.removeLast();
            }
            maxValues.addLast(x);
        }
    }

    public Integer dequeue() {
        Integer result = null;
        if(maxValues.size() > 0) {
            result = queue.removeFirst();
            if(maxValues.getFirst() == result) {
                maxValues.removeFirst();
            }
        }
        return result;
    }

    public Integer max() {
        return maxValues.size() > 0 ? maxValues.getFirst() : null;
    }


}
