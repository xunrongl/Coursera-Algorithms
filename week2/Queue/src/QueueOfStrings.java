/**
 * Linked-list Queue of String implementation
 * Created by lixunrong on 2/15/15.
 */
public class QueueOfStrings {

    private class Node{
        String item;
        Node next;
    }
    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public String dequeue(){
        String item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }

    public void enqueue(String item){
        Node oldlast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
    }


}
