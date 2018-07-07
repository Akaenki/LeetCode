/** Iterative solution of reversing a singly linked list */
public class reverseLinkedListItr {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode front = head;
        ListNode next = head.next;
        head.next = null;

        while(next!=null){
            ListNode temp = next.next;
            next.next = front;
            front = next;
            next = temp;
        }
        return front;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode rev = reverseList(head);
        System.out.println(rev.val);
        System.out.println(rev.next.val);
        System.out.println(rev.next.next.val);
        System.out.println(rev.next.next.next.val);
    }
}
