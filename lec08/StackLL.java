public class StackLL<E> {
    //private int top;
    private LinkedList<E> ll; //DLL with tail

    public StackLL() {
        this.top = -1;
        this.ll = new LinkedList<E>();
    }

    public boolean isEmpty() {
        //head.next == tail
        //tail.prev == head
        return top == -1;
    }

    public void push(E data) {
        top += 1;         
        ll.insertHead(data);
    }

    public E pop() {
        if (isEmpty()) return null;

       E poppedItem = ll.removeHead();
       top -= 1;
       return poppedItem;

       //Case 1: stack is empty... return null;
       //Case 2: stack is non-empty;
       //assume we have a removeTail method in DLL

    }

    public E peek() {
       //Case 1: stack is empty... return null;
       //Case 2: stack is non-empty;

        //FIRST IN LAST OUT 
        return ll.firstElem(); //head.next
    }

    public static void main(String[] args) {
        StackLL stack = new StackLL();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("Top element after popping: " + stack.peek());
    }
}
