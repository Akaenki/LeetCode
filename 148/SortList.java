import java.util.*;

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /* Must use constant space (otherwise using a PQ is trivial) */
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        /* Cut the list into half */
        ListNode fast = head.next.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode lower = sortList(slow.next);
        slow.next = null;
        ListNode upper = sortList(head);
        return merge(upper, lower);
    }

    private static ListNode merge(ListNode upper, ListNode lower){
        ListNode head = new ListNode(0), cur = head;
        while(upper != null && lower != null){
            if(upper.val < lower.val){
                cur.next = upper;
                upper = upper.next;
            } else{
                cur.next = lower;
                lower = lower.next;
            }
            cur = cur.next;
        }
        if(upper == null) cur.next = lower;
        if(lower == null) cur.next = upper;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        head = sortList(head);

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
