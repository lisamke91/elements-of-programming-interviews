public class ComputeKthNodeInorder {

    /*
    10.9
    */

    public static BinaryTree<Integer> findKthNodeBinaryTree(BinaryTree<Integer> tree, int k) {
        if(tree == null || tree.data < k) {
            return null;
        }
        return findKthNodeHelper(tree, 0, k);
    }

    private static BinaryTree<Integer> findKthNodeHelper(BinaryTree<Integer> currentNode, int nodeCount, int k) {
        // base case 1: null node
        if(currentNode == null) {
            return currentNode;
        }
        // calculate current node count
        int currentCount = nodeCount + (currentNode.left != null ? currentNode.left.data : 0);

        // base case 2: current count = k
        if(currentCount == k) {
            return currentNode;
        }

        // recursive case: determine whether to proceed left or right
        if(currentCount > k) {
            // traverse left subtree
            return findKthNodeHelper(currentNode.left, nodeCount, k);
        } else {
            // traverse right subtree
            return findKthNodeHelper(currentNode.right, currentCount + 1, k);
        }
    }
}
