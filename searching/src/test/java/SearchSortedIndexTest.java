import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SearchSortedIndexTest {

    private int expected;
    private List<Integer> list;

    @Test
    public void search1() throws Exception {
        expected = 3;
        list = Arrays.asList(-1,0,1,3,5);

        test(expected, list);
    }

    @Test
    public void search2() throws Exception {
        expected = 2;
        list = Arrays.asList(0,1,2,3,4);

        test(expected, list);
    }

    @Test
    public void search3() throws Exception {
        expected = 0;
        list = Arrays.asList(0,2,6,8,10,11,12,14,15);

        test(expected, list);
    }

    public void test(int expected, List<Integer> list) throws Exception {
        assertEquals(expected, SearchSortedIndex.search(list));
    }

}