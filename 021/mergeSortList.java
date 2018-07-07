public class mergeSortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode merge;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            merge = new ListNode(l1.val);
            l1 = l1.next;
        }else{
            merge = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode front = merge;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                front.next = l1;
                front = front.next;
                l1 = l1.next;
            }else{
                front.next = l2;
                front = front.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) front.next = l2;
        else front.next = l1;
        return merge;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode merge= mergeTwoLists(l1, l2);
        System.out.println(merge.next.next.next.val);
    }
}
