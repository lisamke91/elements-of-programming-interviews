public class Palindromic {

    /*
    8.11
    */

    public static boolean isPalindromic(ListNode<Integer> list) {
        boolean isPalindrome = true;
        ListNode<Integer> currentNode = list;

        int length = 0;
        while(currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        currentNode = list;

        if(length > 1) {
            ListNode<Integer> temp, prevNode = null, forward = null, backward = null;
            int index = 0;
            while(index < length / 2) {
                temp = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = temp;
                index++;
            }

            backward = prevNode;
            if(length % 2 == 0) {
                forward = currentNode;
            } else {
                forward = currentNode.next;
            }

            while(forward != null) {
                if(!forward.data.equals(backward.data)) {
                    isPalindrome = false;
                    break;
                }
                forward = forward.next;
                backward = backward.next;
            }
        }

        return isPalindrome;
    }

}
