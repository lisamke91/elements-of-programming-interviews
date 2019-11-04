public class CyclicRightShift {

    /*
    8.9
    */

    public static ListNode<Integer> shift(int k, ListNode<Integer> list) {

        ListNode<Integer> newEnd = null, currentNode = list;
        int count = 0;
        // get length of list
        while(currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        currentNode = list;

        int index = 0, modShift = k % count;

        while(index++ < modShift && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        if(index > modShift) {
            newEnd = list;
            while(currentNode.next != null) {
                newEnd = newEnd.next;
                currentNode = currentNode.next;
            }

            currentNode.next = list;
            list = newEnd.next;
            newEnd.next = null;
        }

        return list;
    }
}
