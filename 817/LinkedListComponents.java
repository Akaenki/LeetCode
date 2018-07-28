import java.util.*;

public class LinkedListComponents {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int numComponents(ListNode head, int[] G) {
        int N = 0; ListNode top = head;
        while(top != null){
            N++; top = top.next;
        }
        int[] map = new int[N+1]; top = head;
        while(top.next != null){
            map[top.val] = top.next.val+1;
            top = top.next;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i : G) set.add(i);

        for(int i : G){
            if(map[i] != 0) set.remove(map[i]-1);
        }
        return set.size();
    }
}
