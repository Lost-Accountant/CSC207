public interface Queue<T> {
    // <T> means that you need to specify a data type, which will be used later

    /**
     * Append o to me.
     * @param o th item to enqueue.
     */
    void enqueue(T o);

    /**
     * Remove and return the front item.
     * Precondition: not isEmpty()
     * @return the front item
     */
    T dequeue();

    /**
     * Return the front item.
     * Precondition: not isEmpty()
     * @return the front item.
     */
    T front();

    /**
     * Return whether there are any items.
     * @return whether there are any items.
     */
    boolean isEmpty();

    /**
     * Return the number of items in me.
     * @return th number of items in me.
     */
    int size();
}
