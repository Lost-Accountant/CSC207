import java.util.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {
    private LinkedList contents = new LinkedList();

    @Override
    public void enqueue(T o){
        this.contents.addLast(o);
        // use property of LinkedList built-in methods to implement linkedQueue
        // Queue is First in First Out. (FIFO)
        // Stack is LIFO
    }

    @Override
    public T dequeue(){
        return (T) this.contents.removeFirst();
        // has to declare type when type is not certain.
    }

    @Override
    public T front(){
        return (T) this.contents.getFirst();
        // has to declare type when type is not certain.
    }

    @Override
    public boolean isEmpty(){
        return this.contents.isEmpty();
    }

    @Override
    public int size(){
        return this.contents.size();
    }
}
