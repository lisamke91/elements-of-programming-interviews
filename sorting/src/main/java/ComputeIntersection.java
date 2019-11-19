import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ComputeIntersection {

    /*
    14.1
    */

    public static List<Integer> intersection(List<Integer> A, List<Integer> B) {
        if(A.isEmpty() || B.isEmpty()) {
            return Collections.emptyList();
        }

        ArrayList<Integer> intersection = new ArrayList<>();
        ListIterator<Integer> iterA = A.listIterator();
        ListIterator<Integer> iterB = B.listIterator();
        int a = iterA.next();
        int b = iterB.next();

        boolean isFirst = true;

        while(isFirst || iterA.hasNext() && iterB.hasNext()) {
            // System.out.println("a: " + a + ", b: " + b);
            if(isFirst) {
                isFirst = false;
            }

            if(a == b) {
                intersection.add(a);
                int elemnt = a;
                while(iterA.hasNext() && a == elemnt) {
                    a = iterA.next();
                }
                while(iterB.hasNext() && b == elemnt) {
                    b = iterB.next();
                }
            } else if ( a < b) {
                a = iterA.next();
            } else {
                b = iterB.next();
            }
        }

        return intersection;
    }
}
