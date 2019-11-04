public class EvenOddMerge {

    /*
    8.10
    */

    public static ListNode<Integer> merge(ListNode<Integer> list) {

        if(list.next != null) {
            ListNode<Integer> temp, even = list, odd = list.next;

            while(odd != null && odd.next != null) {
                temp = odd.next;
                odd.next = odd.next.next;
                temp.next = even.next;
                even.next = temp;

                // traverse
                even = even.next;
                odd = odd.next;
            }
        }

        return list;
    }

}
