import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ComputeBuildingsWithView {

    /*
    9.6
    */

    public static Deque<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> sequence) {
        LinkedList<BuildingWithHeight> resultStack = new LinkedList<>();
        int index = 0;

        while(sequence.hasNext()) {
            int value = sequence.next();
            while(resultStack.size() > 0 && value > resultStack.peek().height) {
                resultStack.pop();
            }
            resultStack.push(new BuildingWithHeight(index, value));
            index++;
        }

        return resultStack;
    }
}
