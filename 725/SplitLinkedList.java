import java.util.List;

public class SplitLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if(k <= 1) return new ListNode[]{root};
        ListNode top = root;
        ListNode[] res = new ListNode[k];
        if(root == null) return res;
        for(int i = 0; i<k; ++i){
            res[i] = top;
            top = top.next;
            if(top == null) {
                for(int j = 0; j<=i; ++j){
                    res[j].next = null;
                }
                return res;
            }
        }

        while(true) {
            for(int i = 0; i<k; ++i) {
                ListNode[] cur = new ListNode[k];
                for(int j = i; j<k; ++j){
                    cur[j] = res[j].next;
                    if(cur[j] == null){
                        for(int ii = k-1; k>0; --k){
                            res[k].next = null;
                            res[k] = res[k - 1];
                        }
                        res[0].next = null;
                        res[0] = root;
                        return res;
                    }
                }
                System.arraycopy(cur, i, res, i, k-i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
