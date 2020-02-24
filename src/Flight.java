/**
 * A class representing a flight.
 * @author Travis Chamness
 * @version 6/24/2019
 */
public class Flight implements Comparable<Flight>
{
    // TODO Project 3A
    //  define instance variables
    private int flightNumber;
    private int priority;
    final static public int DEFAULT_PRIORITY = 4;


    public Flight(int flightNumber, int priority)
    {
        // TODO Project 3A - Parameterized constructor
        this.flightNumber = flightNumber;
        this.priority = priority;
    }

    private void setPriority(int newPriority)
    {
        // TODO Project 3A - setPriority - Done
        // if the input is invalid sets priority to the default value
        if(newPriority <= DEFAULT_PRIORITY && newPriority > 0)
        {
            this.priority = newPriority;
        }else{
            this.priority = DEFAULT_PRIORITY;
        }

    }

    public int getFlightNumber()
    {
        // TODO Project 3A - getFlightNumber - Done
        return this.flightNumber; // THIS IS A STUB
    }

    public String getFlightName()
    {
        // TODO Project 3A
        return "Flight " + this.flightNumber; // THIS IS A STUB
    }

    public int compareTo(Flight other)
    {
        // TODO Project 3A - compareTo - Done
        return this.priority - other.priority; // THIS IS A STUB
    } // compareTo tests the priority of the flights against each other

    public void updatePriority(int newPriority)
    {
        // TODO Project 3A
        //  changes the flight priority to the new one only if the new one is valid and different
        if(newPriority != this.priority && newPriority <= DEFAULT_PRIORITY && newPriority > 0)
        {
            this.priority = newPriority;
        }

    }

    public String toString()
    {
        // TODO Project 3A
        return "???"; // THIS IS A STUB
    }
}