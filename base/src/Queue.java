import java.util.Iterator;

/**
 * @author xuzhipeng
 * @Title: Queue
 * @ProjectName algorithms
 * @date 2018/12/9 12:37 PM
 * @Description: 队列链表实现
 */
public class Queue<Item>  implements Iterable<Item>{
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N = 0;

    public boolean isEmpty(){return N == 0; }
    public int size(){return N;}
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(first == null) first = last;
        else oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        //if(isEmpty()) last = null; //不是很懂这条。。
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<Item>{
        Node curr = first;
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
