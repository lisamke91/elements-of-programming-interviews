public class ComputeSuccessor {

    /*
    10.10
    */

    public static BinaryTreeParent<Integer> findSuccessor(BinaryTreeParent<Integer> node) {
        BinaryTreeParent<Integer> currentNode = node;

        if(currentNode.right != null) {
            // case 1: has right subtree ->
            currentNode = currentNode.right;
            while(currentNode.left != null) {
                currentNode = currentNode.left;
            }
        } else {
            // case 1: has no right subtree
            boolean foundNextNode = false;
            while(currentNode != null && !foundNextNode) {
                if(currentNode.parent == null) {
                    currentNode = currentNode.parent;
                } else {
                    if(currentNode.parent.left != null && currentNode.parent.left.data.equals(currentNode.data)) {
                        foundNextNode = true;
                    }
                    currentNode = currentNode.parent;
                }
            }
        }

        return currentNode;
    }
}
