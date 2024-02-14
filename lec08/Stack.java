public class Stack<E> {
    private int top;
    private E[] array; //let's assume a fixed size array

    public Stack() {
        this.top = -1;
        this.array = (E[]) new Object[100]; 
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(E data) {
        //Case 1: array is not full
        top += 1;
        array[top] = data;

        //Case 2: array is full - throw exception 
    }

    public E pop() {
        //TOP IS THE INDEX WHICH WAS LAST PUSHED TO THE STACK
        
        //Case 1: array is empty... return null;
        if (isEmpty()) {
            return null;
        }
        //Case 2: array is non-empty;
        E poppedElem = array[top];
        top -= 1;
        return poppedElem;
    }

    public E peek() {
        //Case 1: array is empty... return null;
        //Case 2: array is non-empty;
        return array[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        //top = -1, []
        stack.push(10); 
        //top = 0, [10, .....]
        stack.push(20);
        //top = 1, [10,20,.....]
        stack.push(30);
        //top = 2, [10,20,30, ...]

        System.out.println("Top element: " + stack.peek()); //30

        stack.pop();
        //top = 1, [10,20,x30x, ...]
        stack.pop();
        //top = 0, [10,x20x,x30x, ...]

        System.out.println("Top element after popping: " + stack.peek()); //10

        stack.pop()
        stack.isEmpty() //true
        //print array [10,20,30]
    }
}
