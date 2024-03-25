import java.util.Stack;

public class StackSort {

    public static Stack<Integer> sort(Stack<Integer> s1) {
        //create a stack s2
        Stack<Integer> s2 = new Stack<>();
        
        while (!s1.isEmpty()) {
            int cur = s1.pop();
            //check if cur can be added to s2 while maintaining sorting
            while (!s2.isEmpty() && cur > s2.peek()) {
                s1.push(s2.pop());
            }

            s2.push(cur);
        }

        return s2;
    }

    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>();
        s1.push(10);
        s1.push(0);
        s1.push(7);
        s1.push(1);
        s1.push(9);

        s1 = sort(s1);
        System.out.println(s1);
    }

}
