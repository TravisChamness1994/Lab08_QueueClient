/**
 * A class that implements deque.
 * @author Travis Chamness
 * @version 6/24/2019
 */
public class LinkedDeque<T> implements DequeInterface<T>
{
    private DoubleLinkedNode firstNode; // References node at front of deque
    private DoubleLinkedNode lastNode;  // References node at back of deque
    private int numberOfElements;
    // TODO Project 1A
    //   define numberOfElements instance variable and implement ability to get the size of the collection

    public LinkedDeque()
    {
        this.firstNode = null;
        this.lastNode = null;
        this.numberOfElements = 0;
    } // end default constructor

    public void addToBack(T newEntry)
    {
        DoubleLinkedNode newNode = new DoubleLinkedNode(this.lastNode, newEntry, null);

        if (isEmpty())
            this.firstNode = newNode;
        else
            this.lastNode.next = newNode;

        this.lastNode = newNode;
        this.numberOfElements++;
    } // end addToBack

    public void addToFront(T newEntry)
    {
        DoubleLinkedNode newNode = new DoubleLinkedNode(null, newEntry, this.firstNode);

        if (isEmpty())
            this.lastNode = newNode;
        else
            this.firstNode.previous = newNode;

        this.firstNode = newNode;

        this.numberOfElements++;
    } // end addToFront

    public T getBack() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException("the collection is empty");
        else
            return this.lastNode.data;
    } // end getBack

    public T getFront() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException("the collection is empty");
        else
            return this.firstNode.data;
    } // end getFront

    public T removeFront()
    {
        T front = getFront();  // Might throw EmptyQueueException
        assert (this.firstNode != null);

        this.firstNode = this.firstNode.next;

        if (this.firstNode == null)
            this.lastNode = null;
        else
            this.firstNode.previous = null;

        this.numberOfElements--;
        return front;
    } // end removeFront

    public T removeBack()
    {
        T back = getBack();  // Might throw EmptyQueueException
        assert (this.lastNode != null);

        this.lastNode = this.lastNode.previous;

        if (this.lastNode == null)
            this.firstNode = null;
        else
            this.lastNode.next = null;

        this.numberOfElements--;
        return back;
    } // end removeBack

    public void clear()
    {
        numberOfElements = 0;
        this.firstNode = null;
        this.lastNode = null;
    } // end clear

    public boolean isEmpty()
    {
        return (this.firstNode == null) && (this.lastNode == null);
    } // end isEmpty

    public int getNumberOfElements()
    {
        // TODO Project 1A
        return numberOfElements; // THIS IS A STUB
    }

    public void display()
    {
        DoubleLinkedNode currentNode = this.firstNode;

        if(this.isEmpty())
        {
            System.out.println("The collection is empty; the number of elements is 0");
        }
        else{
            while( currentNode != null ){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }

        System.out.println();
        // TODO Project 1A
    }

    private class DoubleLinkedNode
    {
        private T      data;  	 // Deque entry
        private DoubleLinkedNode next;  	 // Link to next node
        private DoubleLinkedNode previous; // Link to previous node

        private DoubleLinkedNode(T dataPortion)
        {
            this(null, dataPortion, null);
        } // end constructor

        private DoubleLinkedNode(DoubleLinkedNode previousNode, T dataPortion, DoubleLinkedNode nextNode)
        {
            this.data = dataPortion;
            this.next = nextNode;
            this.previous = previousNode;
        } // end constructor

    } // end DoubleLinkedNode
} // end LinkedDeque
