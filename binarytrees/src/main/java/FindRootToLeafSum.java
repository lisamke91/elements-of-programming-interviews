public class FindRootToLeafSum {

    /*
     * 10.6 Find root to path wit specified sum
    */

    public static boolean hasPathSum(BinaryTree<Integer> tree, int targetSum) {
        return hasPathSumHelper(tree, 0, targetSum);
    }

    private static boolean hasPathSumHelper(BinaryTree<Integer> currentNode, int pathWeight, int targetSum) {
        // base case 1: null node
        if(currentNode == null) {
            return false;
        }
        pathWeight += currentNode.data;
        // base case 2: leaf node
        if(currentNode.left == null && currentNode.right == null) {
            return pathWeight == targetSum;
        }
        // recursive case
        return hasPathSumHelper(currentNode.left, pathWeight, targetSum)
                || hasPathSumHelper(currentNode.right, pathWeight, targetSum);
    }
}
