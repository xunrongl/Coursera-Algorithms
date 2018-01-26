import java.util.NoSuchElementException;

/**
 * Queue of String Array implementation
 * Created by lixunrong on 3/9/15.
 */
public class QueueOfStringArray {

    private String[] q;
    private int head = 0;
    private int tail = 0;
    private int N = 0; //number of elements in the queue

    public QueueOfStringArray(){
        q = new String[2];
    }

    public void enqueue(String s){
        //check if the array is full
        if (N == q.length)
            resize(q.length*2);

        q[tail++] = s;
        //wrapped-around
        if (tail == q.length)
            tail = 0;
        N++;
    }
    public int size(){
        return N;
    }

    public String dequeue(){
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        else {
            String out = q[head];
            q[head] = null;
            head++;
            N--;
            //wrapped-around
            if (head == q.length)
                head = 0;
            //shrink size
            if (N > 0 && N == q.length/4)
                resize(q.length/2);
            return out;
        }

    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void resize(int max){
        if (N > max)
            throw new IllegalArgumentException("need more size");
        else {
            String[] tmp = new String[max];
            for (int i = 0; i < N; i++){
                tmp[i] = q[head + i];
//                tmp[i] = q[(head + i) % q.length];
            }
            q = tmp;
            head = 0;
            tail = N;
        }
    }
    /**
     * Unit tests the <tt>ResizingArrayQueue</tt> data type.
     */
    public static void main(String[] args) {
        QueueOfStringArray q = new QueueOfStringArray();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
