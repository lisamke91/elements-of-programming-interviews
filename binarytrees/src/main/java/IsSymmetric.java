public class IsSymmetric {

    /*
    10.2
    */

    public static boolean isSymmetric(BinaryTree<Integer> tree) {
        return tree != null && determineIfSymmetric(tree.left, tree.right);
    }

    private static boolean determineIfSymmetric(BinaryTree<Integer> leftSubtreeNode,
                                                BinaryTree<Integer> rightSubtreeNode) {
        // base case 1, both null
        if(leftSubtreeNode == null && rightSubtreeNode == null) {
            return true;
        }

        // base case 2, one node is null
        if(leftSubtreeNode == null || rightSubtreeNode == null) {
            return false;
        }

        // recursive case
        return leftSubtreeNode.data.equals(rightSubtreeNode.data)
                && determineIfSymmetric(leftSubtreeNode.left, rightSubtreeNode.right)
                && determineIfSymmetric(leftSubtreeNode.right, rightSubtreeNode.left);
    }

}
