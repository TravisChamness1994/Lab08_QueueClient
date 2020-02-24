import sun.awt.image.ImageWatched;

/**
 * A class of stacks whose entries are stored in a deque.
 * @author Travis Chamness
 * @version 6/24/2019
 */
public class DropoutStack<T>
{
    //Instance variables refer to UML diagram. Re-read up, need refresher.
    private LinkedDeque<T> stack;
    private final int capacity;

    // TODO Project 1B
    //   IMPLEMENT ALL THE METHODS DEFINED IN THE UML DIAGRAM
    public DropoutStack(int initialCapacity)
    {
        this.capacity = initialCapacity;
        this.stack = new LinkedDeque<T>();
        // TODO Project 1B
    } // end constructor

    public void push(T newEntry)
    {
        if(this.stack.getNumberOfElements() < this.capacity)
        {
            this.stack.addToFront(newEntry);
        }else
            {
            pop();
            this.stack.addToFront(newEntry);
        }
        // TODO Project 1B
    } // end push

    public T peek()
    {
        T peekValue = null;
        // TODO Project 1B
        if(!this.stack.isEmpty())
        {
            peekValue = this.stack.getFront();
        }
        return peekValue; // THIS IS A STUB
    } // end peek

    public T pop()
    {
        T popValue = null;
        // TODO Project 1B
        if(this.stack.isEmpty())
        {
            System.out.println("Got back null");
        }else{
            popValue = this.stack.removeBack();
        }
        return popValue; // THIS IS A STUB
    } // end pop

    public boolean isEmpty()
    {
        // TODO Project 1B
        return this.stack.isEmpty(); // THIS IS A STUB
    } // end isEmpty

    public void clear()
    {
        this.stack.clear();
        // TODO Project 1B
    } // end clear

    public void display()
    {
        this.stack.display();
        // TODO Project 1B
    }


    public static void main(String args[])
    {
        System.out.println("**************  TESTING DROPOUT STACK  **************\n");
        final int STACK_CAPACITY = 20;
        DropoutStack<Integer> dropoutStack = new DropoutStack<>(STACK_CAPACITY);

        System.out.println("---->  Adding " + STACK_CAPACITY + " items to empty stack with capacity of " + STACK_CAPACITY);
        for (int i = 1; i <= STACK_CAPACITY; i++)
        {
            dropoutStack.push(i);
        }

        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());
        System.out.println("\n----> Adding 5 more items to full stack");
        for (int i = STACK_CAPACITY + 1; i <= STACK_CAPACITY + 5; i++)
        {
            System.out.println("push " + i);
            dropoutStack.push(i);
        }

        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());

        System.out.println("\n---->  Removing all elements from the stack:");
        while (!dropoutStack.isEmpty())
        {
            System.out.println("----> pop " + dropoutStack.pop());
        }

        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());

        System.out.println("\n----> Trying to pop from the empty stack");
        System.out.println("----> Got back " + dropoutStack.pop());

        System.out.println("\n----> Trying to peek at the top of the empty stack");
        System.out.println("----> Got back " + dropoutStack.peek());

        System.out.println("\n----> Adding " + (STACK_CAPACITY + 2) + " items to empty stack of capacity of " + STACK_CAPACITY);
        for (int i = 1; i <= STACK_CAPACITY + 2; i++)
        {
            dropoutStack.push(i);
        }

        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();

        System.out.println("\n---->  Clearing the stack with the clear method");
        dropoutStack.clear();
        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();

        System.out.println("\n---->  Adding " + (STACK_CAPACITY + 1) + " items to the cleared stack with capacity of " + STACK_CAPACITY);
        for (int i = 1; i <= STACK_CAPACITY + 1; i++)
        {
            dropoutStack.push(i);
        }

        System.out.println("---->  The content of the stack is:");
        dropoutStack.display();
        System.out.println("----> The top of the stack is: " + dropoutStack.peek());
    }
}