import org.junit.Test;

import static org.junit.Assert.*;

public class FirstGreaterThanTest {

    private BinaryTree<Integer> expected;
    private BinaryTree<Integer> tree;
    private Integer k;

    @Test
    public void find1() throws Exception {
        tree = BinaryTreeUtil.getEvenBST();
        expected = tree;
        k = 0;

        test(expected, tree, k);
    }

    @Test
    public void find2() throws Exception {
        tree = BinaryTreeUtil.getBST();
        expected = tree.left;
        k = 1;

        test(expected, tree, k);
    }

    private void test(BinaryTree<Integer> expected, BinaryTree<Integer> tree, Integer k) {
        assertEquals(expected, FirstGreaterThan.find(tree,k));
    }

}