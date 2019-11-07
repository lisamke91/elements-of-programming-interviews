public class IsHeightBalanced {

    /*
    10.1
    */

    public static boolean isBalanced(BinaryTree<Integer> tree) {
        int treeHeight = checkTreeHeights(tree);
        return treeHeight > 0;
    }

    private static int checkTreeHeights(BinaryTree<Integer> node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }

        int leftHeight = checkTreeHeights(node.left);
        int rightHeight = checkTreeHeights(node.right);
        if(leftHeight < 0 || rightHeight < 0
                || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
