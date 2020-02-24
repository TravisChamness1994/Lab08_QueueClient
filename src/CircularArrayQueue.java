import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Travis Chamness
 * @version 6/24/2019
 */
public class CircularArrayQueue<T> implements QueueInterface<T>
{
    private T[] queue; // Circular array of queue entries and one unused location
    private int frontIndex; // Index of front entry
    private int backIndex;  // Index of back entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 3;
    private static final int MAX_CAPACITY = 10000;

    public CircularArrayQueue()
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[DEFAULT_CAPACITY + 1];
        this.queue = tempQueue;
        this.frontIndex = 0;
        this.backIndex = DEFAULT_CAPACITY;
        this.initialized = true;
    } // end constructor

    public CircularArrayQueue(T[] initialContent)
    {
        this();
        this.backIndex = this.frontIndex;

        for (int i = 0; i < initialContent.length && initialContent[i] != null; i++)
        {
            enqueue(initialContent[i]);
        }
        // TODO Project 2A - Done

    } // end constructor

    public void enqueue(T newEntry)
    {
        //Ensure Capacity
        checkInitialization();
        this.queue[((this.backIndex + 1) % this.queue.length)] = newEntry;
        this.backIndex = (this.backIndex + 1) % this.queue.length;
        ensureCapacity();
        //System.out.println("enqueue(" + newEntry + ")");               // ***TESTING
        // TODO Project 2A - Enque - Done
        //System.out.println("queue[" + backIndex + "] = " + newEntry);  // ***TESTING
    } // end enqueue

    public T getFront() throws EmptyQueueException
    {
        checkInitialization();
        if(isEmpty())
        {
            throw new EmptyQueueException("The Queue is empty.");
        }
        else return queue[(this.frontIndex + 1) % this.queue.length];
        // TODO Project 2A - Front Index - Done

    } // end getFront

    public T dequeue() throws EmptyQueueException
    {
        checkInitialization();
        // TODO Project 2A - Deque - Done
        T temp = null;

        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            temp = this.queue[(this.frontIndex + 1) % this.queue.length];
            this.queue[((this.frontIndex + 1) % this.queue.length)] = null;
            this.frontIndex = (this.frontIndex + 1) % this.queue.length;
        }


        return temp;
    } // end dequeue

    public boolean isEmpty()
    {
        checkInitialization();
        boolean empty = false;
        if(this.frontIndex == this.backIndex){
            empty = true;
        }
        // TODO Project 2A - isEmpty - Done
        return empty;  // THIS IS A STUB
    } // end isEmpty

    public void clear()
    {
        checkInitialization();
        while(this.backIndex != frontIndex){
            queue[backIndex] = null;
            backIndex--;
        }
        // examine and null out only the elements that are part of the current queue
        // TODO Project 2A - Clear - Done

    } // end clear


    // Throws an exception if this object is not initialized.
    private void checkInitialization()
    {
        if (!this.initialized)
            throw new SecurityException("CircularArrayQueue object is not initialized properly.");
    } // end checkInitialization

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a queue " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
    } // end checkCapacity

    // Doubles the size of the array queue if it is full.
    // Precondition: checkInitialization has been called.
    private void ensureCapacity()
    {
        if(this.backIndex == this.queue.length-1){

            int newCapacity = this.queue.length * 2;
            checkCapacity(newCapacity);
            T[] temp = (T[]) new Object[newCapacity];
            for(int i = 0; i < this.queue.length; i++)
            {
                temp[i] = this.queue[i];
            }
            queue = temp;
        }
        // TODO Project 2A - Ensure Capacity - Done

    } // end ensureCapacity
}
