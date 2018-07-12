import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        /* DEBUG ONLY */
        @Override
        public String toString(){
            String str = ""+this.val;
            ListNode ptr = this.next;
            while(ptr != null){
                str += "->"+ptr.val;
                ptr = ptr.next;
            }
            return str;
        }
    }

    /* Implementation using a Min Heap (Java PriorityQueue)
     * There're always at most K entries in the queue thus each insertion is O(logK)
     * And there will be total of N insertion (Min Heap removal is always O(1))
     * Time complexity: O(logK * N), where N is the number of total nodes
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode ptr = head;

        for(ListNode l : lists){
            if(l != null) queue.offer(l);
        }
        while(!queue.isEmpty()){
            ptr.next = queue.poll();
            ptr = ptr.next;
            if(ptr.next != null) queue.offer(ptr.next);
        }
        return head.next;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        System.out.println(mergeKLists(new ListNode[]{l1, l2, l3}).toString());

    }
}
