public class Remove {

    public static void remove(LL l, Integer i) {
        Node head = l.head;
        Node tail = l.tail;

        //create markers
        Node prev = head;
        Node cur = head.next;

        while (cur != tail) {

            if (cur.data == i) {
                prev.next = cur.next; 
            } else {
                //set previous
                prev = cur;    
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LL l = new LL();
        l.insertFront(1);
        l.insertFront(1);
        l.insertFront(7);
        l.insertFront(1);
        l.insertFront(3);
        System.out.println("Before " + l);

        remove(l, 1);
        System.out.println("After " + l);
    }

}
