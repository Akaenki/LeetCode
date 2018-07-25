import java.util.*;
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list; int ptr = 0, size;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        nested(list, nestedList);
        size = list.size();
    }

    private void nested(List<Integer> list, List<NestedInteger> nest){
        for(NestedInteger n : nest){
            if(n.isInteger()) list.add(n.getInteger());
            else nested(list, n.getList());
        }
    }

    @Override
    public Integer next() {
        return list.get(ptr++);
    }

    @Override
    public boolean hasNext() {
        return ptr < size;
    }
}
