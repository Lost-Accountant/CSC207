public interface Queue<T> {

    void enqueue(T o);

    T head();

    T dequeue();

    int size();
}
