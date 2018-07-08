public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /* Add two extra pointers if do not want the method to be destructive */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int extra = 0;

        ListNode ptr = result;
        while(true){
            if(l1 == null && l2 ==null) break;
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;

            int curval = i + j + extra;

            ptr.next = new ListNode(curval % 10);
            ptr = ptr.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            extra = curval / 10;
        }

        if(extra != 0) ptr.next = new ListNode(extra);
        return result.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
