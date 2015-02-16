/**
 * Resizing Array Implementation
 * Created by lixunrong on 2/15/15.
 */
public class ResizingArrayStackOfStrings {
    private String[] array;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        array = new String[1];
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.println(stack.pop());
            else
                stack.push(s);
        }
    }

    public void push(String s) {
        if (N == array.length)
            resize(2 * array.length);
        array[N++] = s;
    }

    //avoid loitering using garbage collector
    public String pop() {
        String item = array[--N];
        array[N] = null;
        if (N == array.length / 4 && N > 0)
            resize(array.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void resize(int m) {
        String[] copy = new String[m];
        for (int i = 0; i < N; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }
}
