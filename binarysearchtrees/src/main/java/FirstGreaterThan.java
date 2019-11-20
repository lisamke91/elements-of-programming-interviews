public class FirstGreaterThan {

    /*
    15.2
    */

    public static BinaryTree<Integer> find(BinaryTree<Integer> tree, Integer k) {
        //System.out.println(tree);
        if(tree == null) {
            return null;
        }

        if(tree.data > k) {
            if(tree.left == null || tree.left.data <= k) {
                return tree;
            } else {
                return find(tree.left, k);
            }
        } else {
            return find(tree.right, k);
        }
    }
}
