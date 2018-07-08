import java.util.List;

public class IntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB;

        while(a != null){
            a = a.next; lenA++;
        }
        while(b != null){
            b = b.next; lenB++;
        }

        int diff = lenA - lenB;
        a = headA; b = headB;


        for(int i = 0; i<Math.abs(diff); ++i){
            if(diff < 0) b = b.next;
            if(diff > 0) a = a.next;
        }

        while(a != b){
            a = a.next; b = b.next;
        }

        return a;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(0);
        a.next = new ListNode(3);
        ListNode b = new ListNode(2);
        b.next = a.next;

        System.out.println(getIntersectionNode(a, b).val);
    }
}
