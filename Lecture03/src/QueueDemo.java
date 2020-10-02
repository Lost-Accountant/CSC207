import sun.awt.image.ImageWatched;

public class QueueDemo {
    // method to fill a queue, which applies to its child too
    public static void fill(Queue<Integer> queue, int num){
        for (int i = 0; i != num; i++){
            queue.enqueue(i);
        }
    }

    // method to print each element of a queue
    public static void print(Queue<Integer> q){
        for (int i = 0; i != q.size(); i++){
            Integer o = q.dequeue();
            System.out.println(o + ", ");
            q.enqueue(o);
            // put it back so when it loops around
            // the entire queue is unchanged
        }
    }

    public static void main(String [] args){
        Queue<Integer> queue = new LinkedListQueue<Integer>();
        fill(queue, 100);
        print(queue);
    }
}
