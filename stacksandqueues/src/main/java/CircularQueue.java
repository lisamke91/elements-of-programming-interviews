public class CircularQueue {

    /*
    9.8
    */

    private int head = 0, tail = -1, numQueueElements = 0;
    private static final int SCALE_FACTOR = 2;
    private Integer[] entries;

    public CircularQueue(int capacity) {
        this.entries = new Integer[capacity];
    }

    public void enqueue(Integer x) {
        if(numQueueElements == entries.length) {
            Integer [] newArray = new Integer[entries.length * SCALE_FACTOR];
            int newIndex = 0;
            int index = head;
            while(newIndex < numQueueElements) {
                newArray[newIndex++] = entries[index];
                index = index == entries.length - 1 ? 0 : index + 1;
            }
            head = 0;
            tail = numQueueElements - 1;
            entries = newArray;
        }
        tail = tail == entries.length - 1 ? 0 : tail + 1;
        entries[tail] = x;
        numQueueElements++;
    }

    public Integer dequeue() {
        Integer element = null;
        if(numQueueElements > 0 ) {
            element = entries[head];
            entries[head] = null;
            head = head == entries.length - 1 ? 0 : head + 1;
        }
        return element;
    }

    public int size() {
        return numQueueElements;
    }

}
