import java.util.Hashtable;

public class LRUCache {
    private class Node{
        Node prev, next;
        int value, key;
        public Node(Node prev, Node next, int value, int key){
            this.prev = prev;
            this.next = next;
            this.value = value;
            this.key = key;
        }
    }

    private Node head;
    private int size, capacity;
    private Hashtable<Integer, Node> hash;

    public LRUCache(int capacity) {
        head = new Node(null, null, -1, -1);
        size = 0;
        this.capacity = capacity;
        hash = new Hashtable<>();
    }

    public int get(int key) {
        if(!hash.containsKey(key)) return -1;
        Node renew = hash.get(key);
        renew.prev.next = renew.next;
        renew.next.prev = renew.prev;
        Node temp = head.next;
        head.next = renew; renew.next = temp;
        temp.prev = renew; renew.prev = head;
        return renew.value;
    }

    public void put(int key, int value) {
        if(size == 0){
            Node cur = new Node(head, head, value, key);
            head.next = cur; head.prev = cur;
            hash.put(key, cur);
        } else {
            Node temp = head.next;
            Node cur = new Node(head, temp, value, key);
            temp.prev = cur; head.next = cur;
            if (hash.containsKey(key)) {
                Node remove = hash.remove(key);
                remove.prev.next = remove.next;
                remove.next.prev = remove.prev;
            } else if (size == capacity) {
                Node remove = head.prev;
                remove.prev.next = remove.next;
                remove.next.prev = remove.prev;
                hash.remove(remove.key);
            }
            hash.put(key, cur);
        }
        size = hash.size();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
