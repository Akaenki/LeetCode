import java.util.*;

public class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private int[] list;
    private int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        map = new HashMap<>();
        list = new int[256];
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, size);
        list[size++] = val;
        if(size == list.length) resize(list.length*2);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        if(idx != size-1){
            list[idx] = list[--size];
            map.put(list[idx], idx);
        }
        else size--;
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int rand = (int)(Math.random() * size);
        return list[rand];
    }

    private void resize(int capacity){
        int[] resized = new int[capacity];
        System.arraycopy(list,0,resized,0,size);
        list = resized;
    }
}
