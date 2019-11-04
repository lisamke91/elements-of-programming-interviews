public class DeleteKthLastNode {

    /*
     * 8.7 Without knowing the length of a linked list, it is not trivial to delete the kth last
     * element in a singly linked list.
     *
     * Given a singly linked list and an integer k, write a program
     * to remove the kth last element from the list. Your algorithm cannot use more than a few words
     * of storage, regardless of the length of the list. In particular,you cannot assume that it is
     * possible to record the length of the list.
    */

    public static void deleteNode(ListNode<Integer> list, int k) {
        ListNode<Integer> endNode = list, nodeToDelete = list;

        int index = 0;
        while(index++ < k && endNode != null) {
            endNode = endNode.next;
        }

        if(endNode != null) {
            if(endNode.next == null) {
                list = nodeToDelete;
            }

            while(endNode != null) {
                endNode = endNode.next;
                if(endNode == null && k == 1) {
                    nodeToDelete.next = null;
                }
                nodeToDelete = nodeToDelete.next;
            }

            if(nodeToDelete != null) {
                nodeToDelete.data = nodeToDelete.next.data;
                nodeToDelete.next = nodeToDelete.next.next;
            }
        }
    }
}
