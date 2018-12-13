import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];//栈元素
    private int N = 0; //栈元素的个数
    public boolean isEmpty(){return N == 0 ;}
    public int size(){ return N ;}
    public void reSize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i<N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        if (N == a.length) reSize(2*N +1);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N ==a.length /4) reSize(a.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() { }
    }
}
