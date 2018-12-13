import java.util.Iterator;

/**
 * @author xuzhipeng
 * @Title: Stack
 * @ProjectName algorithms
 * @date 2018/12/912:00 PM
 * @Description: 用链表实现的下压栈
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first; // 栈顶元素
    private int N = 0; // 栈元素个数
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){ return N == 0;}
    public int size(){ return N;}
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() { }
    }
}
