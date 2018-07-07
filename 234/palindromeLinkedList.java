/** Solution using O(n) time and O(1) space */
public class palindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode mid = head;
        ListNode tail = head;
        while(tail.next!=null && tail.next.next!=null){
            mid = mid.next;
            tail = tail.next.next;
        }
        ListNode rev = reverseList(mid.next);

        /** This step is also O(n), the total process is O(n) in time
         *  and only three new nodes are created, which is O(1) in space */
        while(rev!=null){
            if(head.val != rev.val) return false;
            rev = rev.next; head = head.next;
        }
        return true;
    }

    /** Reverse is an O(n) process */
    private static ListNode reverseList(ListNode head) {
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
        head.next = new ListNode(1);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
