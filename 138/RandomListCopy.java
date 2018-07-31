public class RandomListCopy {

    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode top = head;
        while(top != null){
            RandomListNode next = top.next;
            top.next = new RandomListNode(top.label);
            top.next.next = next;
            top = next;
        }

        top = head;
        while(top != null){
            if(top.random != null)
                top.next.random = top.random.next;
            top = top.next.next;
        }

        RandomListNode root = new RandomListNode(0), ctop = root;
        top = head;
        while(top != null){
            RandomListNode next = top.next.next;
            ctop.next = top.next;
            ctop = ctop.next;
            top.next = next;
            top = next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        RandomListNode input = new RandomListNode(1);
        input.next = new RandomListNode(2);
        input.next.next = new RandomListNode(3);
        input.random = input.next.next;
        input.next.random = input;

        RandomListCopy o = new RandomListCopy();
        RandomListNode copy = o.copyRandomList(input);
        System.out.println(input.label);
        System.out.println(input.random.label);
    }
}
