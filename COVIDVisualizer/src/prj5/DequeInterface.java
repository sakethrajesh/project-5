package prj5;/** * An interface for the ADT deque. *  * @author Frank M. Carrano * @author Timothy M. Henry * @version 4.0 * @param <T> generic type for the deque */public interface DequeInterface<T>{    /**     * Adds a new entry to the front of this dequeue.     *      * @param newEntry     *            An object to be added.     */    public void addToFront(T newEntry);    /**     * Adds a new entry to the back of this dequeue.     *      * @param newEntry     *            An object to be added.     */    public void addToBack(T newEntry);    /**     * Removes and returns the front entry of this dequeue.     *      * @return The object at the front of the dequeue.     * @throws EmptyQueueException     *             if the dequeue is empty before the operation.     */    public T removeFront();    /**     * Removes and returns the back entry of this dequeue.     *      * @return The object at the back of the dequeue.     * @throws EmptyQueueException     *             if the dequeue is empty before the operation.     */    public T removeBack();    /**     * Retrieves the front entry of this dequeue.     *      * @return The object at the front of the dequeue.     * @throws EmptyQueueException     *             if the dequeue is empty before the operation.     */    public T getFront();    /**     * Retrieves the back entry of this dequeue.     *      * @return The object at the back of the dequeue.     * @throws EmptyQueueException     *             if the dequeue is empty before the operation.     */    public T getBack();    /**     * Detects whether this dequeue is empty.     *      * @return True if the queue is empty, or false otherwise.     */    public boolean isEmpty();    /**     * Removes all entries from this dequeue.     */    public void clear();} // end DequeInterface