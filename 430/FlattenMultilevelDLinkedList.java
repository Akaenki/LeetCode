import java.util.Stack;

public class FlattenMultilevelDLinkedList {
    public static class Node {
        int val;
        Node prev,next,child;
        public Node() {}
        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public static Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node ptr = head;
        while(ptr != null){
            if(ptr.child!=null){
                if(ptr.next!=null) stack.push(ptr.next);
                ptr.next = ptr.child;
                ptr.next.prev = ptr;
                ptr.child = null;
            }
            if(ptr.next == null && !stack.isEmpty()){
                ptr.next = stack.pop();
                ptr.next.prev = ptr;
            }
            ptr = ptr.next;
        }
        return head;
    }
}
