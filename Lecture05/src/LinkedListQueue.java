import java.util.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {
    private LinkedList<T> contents = new LinkedList<T>();

    @Override
    public void enqueue(T item){
        contents.add(item);
    }

    @Override
    public T head(){
        return contents.getFirst();
    }

    @Override
    public T dequeue(){
        return contents.removeFirst();
    }

    @Override
    public int size(){
        return contents.size();
    }
}
