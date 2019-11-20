public class IsBST {

    /*
    15.1
    */
    private static class MinMax {
        int min;
        int max;
    }

    public static boolean isBST(BinaryTree<Integer> tree) {
        return isBSTHelper(tree) != null;
    }

    private static MinMax isBSTHelper(BinaryTree<Integer> node) {
        //System.out.println(node);
        MinMax minMax = new MinMax();
        MinMax leftMinMax;
        MinMax rightMinMax;
        // base case node has no children
        if(node.left == null && node.right == null) {
            minMax.max = node.data;
            minMax.min = node.data;
        } else if (node.right == null) {
            // node has no right children
            leftMinMax = isBSTHelper(node.left);
            if(leftMinMax != null && leftMinMax.max < node.data) {
                minMax.max = node.data;
                minMax.min = leftMinMax.min;
            } else {
                minMax = null;
            }
        } else if (node.left == null) {
            // node has no left children
            rightMinMax = isBSTHelper(node.right);
            if(rightMinMax != null && rightMinMax.min > node.data) {
                minMax.min = node.data;
                minMax.max = rightMinMax.max;
            } else {
                minMax = null;
            }
        } else {
            // node has children
            leftMinMax = isBSTHelper(node.left);
            rightMinMax = isBSTHelper(node.right);
            if(leftMinMax != null && leftMinMax.max < node.data && rightMinMax != null && rightMinMax.min > node.data) {
                minMax.min = leftMinMax.min;
                minMax.min = rightMinMax.max;
            } else {
                minMax = null;
            }
        }
        return minMax;
    }
}
