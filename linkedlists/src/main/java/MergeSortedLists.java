public class MergeSortedLists {

    /*
    8.1
    */

    public static ListNode<Integer> mergeLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> prevNode = null, currNode1 = list1, currNode2 = list2;

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        while(currNode1 != null & currNode2 != null) {
            while(currNode2 != null && currNode1.data > currNode2.data) {
                if(prevNode != null) {
                    prevNode.next = currNode2;
                }
                prevNode = currNode2;
                currNode2 = currNode2.next;
                prevNode.next = currNode1;
            }
            prevNode = currNode1;
            currNode1 = currNode1.next;
        }

        if(currNode2 != null) {
            prevNode.next = currNode2;
        }

        return list1;
    }
}
