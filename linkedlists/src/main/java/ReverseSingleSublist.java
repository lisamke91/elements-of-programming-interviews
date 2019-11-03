public class ReverseSingleSublist {

    /*
    8.2
    */

    public static ListNode<Integer> reverseSublist(ListNode<Integer> input, int s, int f) {
        ListNode<Integer> sNode = null, temp, prevNode = null, currNode = input, nextNode = null;
        int index = 1;

        while(index < s) {
            if(index == s - 1) {
                prevNode = currNode;
            }
            currNode = currNode.next;
            index++;
        }

        sNode = currNode;

        // reverse sublist
        while(index <= f) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            index++;
        }

        // swap beg end of list pointer
        if(s == 1) {
            input = prevNode;
        }

        if(sNode.next != null) {
            sNode.next.next = prevNode;
        }
        sNode.next = currNode;

        return input;
    }
}
