/**
 * Array implementation
 * Created by lixunrong on 2/15/15.
 */
public class StackOfStringArray {

    private String[] array;
    private int N = 0;

    public StackOfStringArray(int capacity) {
        array = new String[capacity];
    }

    public static void main(String[] args) {
        StackOfStringArray stack = new StackOfStringArray(5);

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.println(stack.pop());
            else
                stack.push(s);
        }
    }

    public void push(String s) {
        array[N++] = s;
    }

    public String pop() {
        return array[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
