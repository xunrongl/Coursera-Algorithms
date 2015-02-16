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

    // may have loitering issue
    /*
    public String pop() {
        return array[--N];
    }*/

    public void push(String s) {
        array[N++] = s;
    }

    //avoid loitering using garbage collector
    public String pop() {
        String item = array[--N];
        array[N] = null;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
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
}
