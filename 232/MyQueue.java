import java.util.*;

public class MyQueue {
    Stack<Integer> s1, s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>(); s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()){
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
