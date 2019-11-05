import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComputeBinaryTreeNodes {

    /*
    9.7
    */

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTree<Integer> tree) {
        LinkedList<List<Integer>> depthsList = new LinkedList<>();
        LinkedList<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.add(tree);
        int leftAtCurrentDepth = 1, numNextDepth = 0, depth = 0;

        while(queue.size() > 0) {
            leftAtCurrentDepth--;
            BinaryTree<Integer> currentNode = queue.removeFirst();

            if(depth > depthsList.size() - 1) {
                depthsList.add(new LinkedList<>());
            }
            depthsList.get(depth).add(currentNode.data);

            if(currentNode.left != null) {
                queue.addLast(currentNode.left);
                numNextDepth++;
            }

            if(currentNode.right != null) {
                queue.addLast(currentNode.right);
                numNextDepth++;
            }

            if(leftAtCurrentDepth == 0) {
                leftAtCurrentDepth = numNextDepth;
                numNextDepth = 0;
                depth++;
            }
        }


        return depthsList;
    }
}
