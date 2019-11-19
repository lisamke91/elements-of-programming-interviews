import java.util.ArrayList;
import java.util.List;

public class MergeSorted {

    /*
    14.2
    */

    public static void merge(List<Integer> A, int m, List<Integer> B, int n) {
        if(m + n <= A.size()) {
            int endIndex = m + n - 1;
            m--;
            n--;

            while (m >= 0) {
                if (n >= 0 && B.get(n) > A.get(m)) {
                    A.set(endIndex, B.get(n));
                    n--;
                } else {
                    A.set(endIndex, A.get(m));
                    m--;
                }
                endIndex--;
            }

            while (n >= 0) {
                A.set(endIndex, B.get(n));
                n--;
                endIndex--;
            }
        }
    }
}
