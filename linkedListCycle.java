/** This method will destroy the original list
 *  A better solution is to use two runners,
 *  one moves one step forward each time an the other moves two steps
 */
public class linkedListCycle {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode dum = new ListNode(0);
        ListNode ptr = head;
        while(ptr!=null){
            if(ptr.next==dum) return true;
            ListNode temp = ptr;
            ptr = ptr.next;
            temp.next = dum;
        }
        return false;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = head;
        //head.next = new ListNode(1);
        //head.next.next = new ListNode(1);
        //head.next.next.next = head;

        System.out.println(hasCycle(head));
    }
}
