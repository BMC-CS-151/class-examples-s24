public class Reverse {

    public static void reverse(LL l) {
        Node head = l.head;
        Node tail = l.tail;

        //create markers
        Node prev = head.next;
        Node cur = head.next.next; //prev.next
        //if cur == null: return;

        Node next = head.next.next.next; //cur.next

        while (cur != tail) {
            //update link
            cur.next = prev;

            //move markers
            prev = cur;
            cur = next;
            next = next.next;
        }

        //update head and tail links
        head.next.next = tail;
        head.next = prev;
    }

    public static void main(String[] args) {
        LL l = new LL();
        l.insertFront(5);
        l.insertFront(1);
        l.insertFront(7);
        l.insertFront(10);
        l.insertFront(3);
        System.out.println("Before " + l);

        reverse(l);
        System.out.println("After " + l);
    }

}
