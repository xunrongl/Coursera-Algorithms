import java.util.Stack;

/**
 * StackOfString Linked-list implementation
 * Created by lixunrong on 2/15/15.
 */
public class StackOfString {

    private class Node{
        String item;
        Node next;
    }

    private Node first = null;

    public StackOfString(){

    }

    public void push(String s){
        Node oldfirst = first;
        first = new Node();
        first.item = s;
        first.next = oldfirst;

    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args){
        StackOfString stack = new StackOfString();

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.println(stack.pop());
            else
                stack.push(s);
        }
    }
}
