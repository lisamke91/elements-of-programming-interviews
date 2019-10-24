import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBootcampProblemTest {
    @Test
    public void testReOrder() {
        int [] inputArr = {1, 3, 2, 3, 4, 7};
        int [] resultArr = {4, 2, 3, 3, 1, 7};
        assertArrayEquals(resultArr, ArrayBootcampProblem.reorderArr(inputArr));
    }
}
