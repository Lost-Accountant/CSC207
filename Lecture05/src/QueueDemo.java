public class QueueDemo {
    public static void fill(Queue<Integer> queue, int num){
        for (int i = 0; i != num; i++){
            queue.enqueue(i);
        }
    }

    public static void main(String[] args){
        // Here is where we decided which Queue implementation to use
        Queue<Integer> queue = new LinkedListQueue<>();
        fill(queue, 25);
        System.out.println(queue);
        while(queue.size() != 0){
            System.out.println(queue.dequeue());
        }
    }
}
