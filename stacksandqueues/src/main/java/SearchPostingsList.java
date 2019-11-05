public class SearchPostingsList {

    /*
    9.5
    */

    public static void setJumpOrderRecursive(PostingListNode<Integer> node) {
        recursiveSolution(node, 0);
    }

    private static void recursiveSolution(PostingListNode<Integer> node, int order) {
        if(node != null && node.data < 0 ) {
            node.data = order;
            recursiveSolution(node.jump, order + 1);
        }
    }

    public static void setJumpOrderIterative(PostingListNode<Integer> node) {

    }
}
