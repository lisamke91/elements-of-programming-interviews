import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class InorderIterative {

    /*
    10.7
    */

    public static List<Integer> BSTInOrder(BinaryTree<Integer> tree) {
        LinkedList<BinaryTree<Integer>> stack = new LinkedList<>();
        LinkedList<Integer> inOrder = new LinkedList<>();;
        stack.push(tree);

        BinaryTree<Integer> currentNode;
        BinaryTree<Integer> leftNode;
        while(stack.size() > 0) {
            currentNode = stack.pop();
            leftNode = currentNode.left;
            // base case: both children null
            if(currentNode.left == null & currentNode.right == null) {
                inOrder.add(currentNode.data);
            } else {
                // push right child onto stack and disconnect
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                    currentNode.right = null;
                }

                // if left child, disconnect and push current node on stack
                if (leftNode != null) {
                    currentNode.left = null;
                    stack.push(currentNode);
                    stack.push(leftNode);
                } else {
                    inOrder.add(currentNode.data);
                }
            }
        }

        return inOrder;
    }
}
