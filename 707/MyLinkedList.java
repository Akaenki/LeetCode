public class MyLinkedList {
        private class Node {
            int val;
            Node next;
            Node(int _val, Node _next){
                val = _val;
                next = _next;
            }
        }

        private Node sentinel;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            sentinel = new Node(0, null);
            sentinel.next = sentinel;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index >= size) return -1;
            Node r = sentinel.next;
            while(index-- > 0) r = r.next;
            return r.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            size += 1;
            sentinel.next = new Node(val,sentinel.next);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            int idx = size; size++;
            Node r = sentinel.next;
            while(idx-- > 1) r = r.next;
            r.next = new Node(val,null);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index > size) return;
            if(index == size) { addAtTail(val); return; }
            size++;
            Node r = sentinel.next;
            while(index-- > 1) r = r.next;
            r.next = new Node(val, r.next);
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index >= size) return;
            size--;
            Node r = sentinel.next;
            while(index-- > 1) r = r.next;
            r.next = r.next.next;
        }
    }

}
