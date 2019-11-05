import java.util.LinkedList;

public class StackWithMax {

    /*
    9.1
    */

    private LinkedList<Integer> stack;
    private LinkedList<Integer> maxList;

    public StackWithMax() {
        stack = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public Integer max() {
        if(maxList.size() > 0) {
            return maxList.getFirst();
        }
        return 0;
    }

    public Integer pop() {
        int poppedValue = 0;
        if(stack.size() > 0) {
            poppedValue = stack.getFirst();
            stack.removeFirst();
            maxList.removeFirst();
        }
        return poppedValue;
    }

    public void push(Integer x) {
        stack.push(x);
        if(maxList.size() > 0) {
            maxList.push(Math.max(x, maxList.getFirst()));
        } else {
            maxList.push(x);
        }
    }
}
