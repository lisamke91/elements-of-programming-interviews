import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeToLinkedList {

    /*
    10.14
    */

    public static List<BinaryTree<Integer>> createListOfLeaves(BinaryTree<Integer> tree) {
        LinkedList<BinaryTree<Integer>> leavesList = new LinkedList<>();
        LinkedList<BinaryTree<Integer>> stack = new LinkedList<>();

        stack.push(tree);

        while(stack.size() > 0) {
            BinaryTree<Integer> currentNode = stack.pop();

            if(currentNode.left == null && currentNode.right == null) {
                leavesList.add(currentNode);
            }
            if(currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        return leavesList;
    }

}
