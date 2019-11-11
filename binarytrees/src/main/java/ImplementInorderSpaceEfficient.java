import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ImplementInorderSpaceEfficient {

    /*
    10.11
    */

    public static List<Integer> inorderTraversal(BinaryTreeParent<Integer> tree) {
        List<Integer> inOrderNodes = new LinkedList<>();

        // find first node
        BinaryTreeParent<Integer> currentNode = tree;
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        inOrderNodes.add(currentNode.data);

        // iterate and continuously find next node
        while(currentNode != null) {
            if(currentNode.right != null) {
                // case has right child
                currentNode = currentNode.right;
                while(currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                inOrderNodes.add(currentNode.data);
            } else {
                // case does not have right child
                boolean isNodeFound = false;
                while(currentNode != null && !isNodeFound) {
                    if(currentNode.parent != null && currentNode.parent.left != null
                            && currentNode.parent.left.equals(currentNode)) {
                        isNodeFound = true;
                        inOrderNodes.add(currentNode.parent.data);
                    }
                    currentNode = currentNode.parent;
                }
            }
        }

        return inOrderNodes;
    }
}
