import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PreorderIterative {

    /*
    10.8
    */

    public static List<Integer> BSTPreOrder(BinaryTree<Integer> tree) {
        LinkedList<BinaryTree<Integer>> stack = new LinkedList<>();
        LinkedList<Integer> preOrder = new LinkedList<>();

        BinaryTree<Integer> node;
        stack.push(tree);
        while(stack.size() > 0) {
            node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            preOrder.add(node.data);
        }
        return preOrder;
    }
}
