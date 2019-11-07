public class ComputeLowestCommonAncestor {

    /*
     * 10.3
     *
    */

    private static class LCAObject{
        BinaryTree<Integer> LCANode;
        boolean foundNode0;
        boolean foundNode1;
    }

    public static BinaryTree<Integer> LCA(BinaryTree<Integer> tree, BinaryTree<Integer> node0, BinaryTree<Integer> node1) {

        LCAObject lcaObject = getLCA(tree, node0, node1);

        return lcaObject.LCANode;
    }

    private static LCAObject getLCA(BinaryTree<Integer> currentNode, BinaryTree<Integer> node0, BinaryTree<Integer> node1) {
        LCAObject lcaObject = new LCAObject();
        // base case null node
        if(currentNode == null) {
            lcaObject.LCANode = null;
            lcaObject.foundNode0 = false;
            lcaObject.foundNode1 = false;
            return lcaObject;
        }
        // recursive case left
        LCAObject lcaObjectLeft = getLCA(currentNode.left, node0, node1);

        if(lcaObjectLeft.LCANode != null) {
            return lcaObjectLeft;
        }

        if(lcaObjectLeft.foundNode0 && lcaObjectLeft.foundNode1) {
            lcaObjectLeft.LCANode = currentNode;
            return lcaObjectLeft;
        }

        // recursive case right
        LCAObject lcaObjectRight = getLCA(currentNode.right, node0, node1);
        if(lcaObjectRight.LCANode != null) {
            return lcaObjectRight;
        }

        lcaObject.foundNode1 = lcaObjectLeft.foundNode1 || lcaObjectRight.foundNode1
                || currentNode.data.equals(node0.data);
        lcaObject.foundNode0 = lcaObjectLeft.foundNode0 || lcaObjectRight.foundNode0
                || currentNode.data.equals(node1.data);

        if(lcaObject.foundNode0 && lcaObject.foundNode1) {
            lcaObject.LCANode = currentNode;
        }

        return lcaObject;

    }
}
