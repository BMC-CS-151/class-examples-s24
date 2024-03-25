import java.util.Stack;

public class StackRemove {

    public static Stack<Integer> remove(Stack<Integer> s1, Integer i) {
        //create a stack s2
        Stack<Integer> s2 = new Stack<>();
        
        while (!s1.isEmpty()) {
            int cur = s1.pop();

            if (cur != i) {
                s2.push(cur);
            }
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return s1;
    }

    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>();
        s1.push(10);
        s1.push(1);
        s1.push(7);
        s1.push(1);
        s1.push(9);
        s1.push(1);

        System.out.println(s1);
        s1 = remove(s1, 1);
        System.out.println(s1);
    }

}
