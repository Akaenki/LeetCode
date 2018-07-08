/* Another solution do not use any java lib ds */
public class MinStackDS {
    private class Node{
        int val; int min;
        Node next;
        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node stack;

    public MinStackDS() {
        stack = null;
    }

    public void push(int x) {
        if(stack == null) stack = new Node(x, x, stack);
        else{
            int min = Math.min(stack.min, x);
            stack = new Node(x, min, stack);
        }
    }

    public void pop() {
        stack = stack.next;
    }

    public int top() {
        return stack.val;
    }

    public int getMin() {
        return stack.min;
    }

    public static void main(String[] args){
        MinStackDS ms = new MinStackDS();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
