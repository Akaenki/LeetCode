
public class OldEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head, even = head.next;

        ListNode ro = odd, re = even;
        while(ro != null && re != null){
            ro.next = re.next;
            if(re.next == null) break;
            re.next = ro.next.next;

            ro = ro.next; re = re.next;
        }
        ro.next = even;

        return odd;
    }
}
