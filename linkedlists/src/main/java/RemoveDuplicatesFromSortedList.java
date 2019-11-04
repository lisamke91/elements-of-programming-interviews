public class RemoveDuplicatesFromSortedList {

    /*
     * 8.8 Write a program that takes as input a singly linked list of integers
     * in sorted order,and removes duplicates from it. The list should be sorted.
    */

    public static void removeDuplicates(ListNode<Integer> list) {
        if(list != null) {
            ListNode<Integer> current = list, nextNode = list.next;

            while(nextNode != null) {
                if(current.data.equals(nextNode.data)) {
                    current.next = nextNode.next;
                } else {
                    current = current.next;
                }
                nextNode = nextNode.next;
            }
        }
    }

}
