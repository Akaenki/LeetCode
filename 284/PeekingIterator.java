import java.util.*;
class PeekingIterator implements Iterator<Integer> {

    private Stack<Integer> stack;
    private Iterator<Integer> itr;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        stack = new Stack<>();
        itr = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!stack.isEmpty()) return stack.peek();
        if(!itr.hasNext()) return null;
        int next = itr.next();
        stack.push(next);
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!stack.isEmpty()) return stack.pop();
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext() || !stack.isEmpty();
    }
}