public class Test {
    public static void main(String[] args){
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        for(String s : queue){
            System.out.println(s);
        }
    }
}
