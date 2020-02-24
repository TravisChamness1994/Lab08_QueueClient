/**
 * A class that implements a cipher with repeating key algorithm.
 *
 * @author Travis Chamness
 * @version 6/24/2019
 */


public class Cipher
{
    private Integer[] key;
    private final int ADD_FACTOR = 1;
    private final int SUBTRACT_FACTOR = -1;

    public Cipher(Integer... key)
    {
        this.key = key;
        // TODO Project 2B - Done

    }


    public String encode(String message)
    {
        // TODO Project 2B - Encode - Work
        //calls code method with ADD_FACTOR

        return code(message, ADD_FACTOR); // THIS IS A STUB
    }

    public String decode(String encoded)
    {
        // TODO Project 2B - Decode
        //calls code method with SUBTRACT_FACTOR

        return code(encoded, SUBTRACT_FACTOR); // THIS IS A STUB
    }

    private String code(String message, int addOrSubtractFactor)
    {
        // TODO Project 2B - Code - Work
        // calls getKeyQueue to get the queue for encoding and decoding
        Integer temp;
        StringBuilder encoded = new StringBuilder();
        QueueInterface<Integer> keyQueue = getKeyQueue();
        for(int i = 0; i < message.length(); i++)
        {

            temp = addOrSubtractFactor * keyQueue.dequeue();
            encoded.append((char)(message.charAt(i) + temp));
            keyQueue.enqueue(temp*addOrSubtractFactor);

        }

        return encoded.toString();
    }

    private QueueInterface<Integer> getKeyQueue()
    {
        // TODO Project 2B - Work
        // utilize CircularArrayQueue secondary constructor
        CircularArrayQueue circularArray = new CircularArrayQueue(this.key);
        return circularArray; // THIS IS A STUB
    }


    public static void main(String args[])
    {
        System.out.println("**************  TESTING THE CIPHER  **************\n");
        Cipher cipher = new Cipher(5, 12, -3, 8, -9, 4, 10, 2, 3, 5, 1);
        String encoded = cipher.encode("All programmers are playwrights and all computers are lousy actors.");
        System.out.println("--->The original message encoded is:");
        System.out.println(encoded);
        String decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);

        encoded = cipher.encode("There is no elevator to success, You have to take the stairs...");
        System.out.println("\n--->The original message encoded is:");
        System.out.println(encoded);
        decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);

        cipher = new Cipher(3, 1, 7, 4, 2, 5);
        encoded = cipher.encode("Trust but Verify");
        System.out.println("\n--->The original message encoded is:");
        System.out.println(encoded);
        decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);

        encoded = cipher.encode("race car");
        System.out.println("\n--->The original message encoded is:");
        System.out.println(encoded);
        decoded = cipher.decode(encoded);
        System.out.println("--->The original message decoded is:");
        System.out.println(decoded);
    }
}


