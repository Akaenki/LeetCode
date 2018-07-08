import java.util.ArrayList;
import java.util.List;

/* every method is O(1) in time */
public class MinStack {
    private class Node {
        int val; int min;
        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    private List<Node> stack;
    private int size;

    public MinStack() {
        stack = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
        if(size == 0) stack.add(new Node(x, x));
        else {
            int min = Math.min(stack.get(size-1).min, x);
            stack.add(new Node(x, min));
        }
        size++;
    }

    public void pop() {
        stack.remove(--size);
    }

    public int top() {
        return stack.get(size-1).val;
    }

    public int getMin() {
        return stack.get(size-1).min;
    }

    public static void main(String[] args){
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
