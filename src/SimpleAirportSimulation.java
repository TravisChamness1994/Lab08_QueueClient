import java.util.*;

/**
 * A class that simulates a simple one-runway airport.
 * Planes awaiting departing, queue on the ground;
 * those waiting to land queue in the air.
 * A plane on the ground must depart before a plane in the air can land.
 *
 * @author Travis Chamness
 * @version 6/24/2019
 */
public class SimpleAirportSimulation
{
    private Random randomGenerator;
    private PriorityQueue<Flight> landingQueue;
    private ArrayDeque<Flight> departingQueue;
    private ArrayList<Flight> poolOfInactiveFlights;
    private final int NUMBER_OF_CONTAINERS = 3;

    private int numberOfFlightsToDepart;
    private int totalNumberOfFlightsDeparted;
    private int numberOfFlightsToLand;
    private int totalNumberOfFlightsLanded;

    private final int DURATION = 50;
    private final int TOTAL_NUMBER_OF_FLIGHTS = 100;
    private final int MAXIMUM_NUMBER_OF_FLIGHTS_TO_DEPART = 20;
    private final int PROBABLITY_OF_LANDING = 50;
    private final int PROBABLITY_OF_DEPARTING = 50;
    private final int PROBABILITY_OF_ADDING_NEW_FLIGHT = 75;
    private final int PERCENT100 = 100;

    public static final int SORT_BY_PRIORITY = 0;
    public static final int SORT_BY_FLIGHT_NUMBER = 1;


    /**
     * Creates an airport with no airplanes.
     */
    public SimpleAirportSimulation(int priorityMode)
    {
        System.out.println("\n*** Welcome to CI Airport with one departing and one landing runways that can service up to " + TOTAL_NUMBER_OF_FLIGHTS + " flights ***");
        System.out.println("                    with maximum of " + MAXIMUM_NUMBER_OF_FLIGHTS_TO_DEPART + " flights in the departing queue");
        System.out.println("                       ******************************************");
        System.out.println();

        this.randomGenerator = new Random(101);

        // TODO Project 3B
        //     initialize all instance variables



        System.out.println("Creating and distributing " + TOTAL_NUMBER_OF_FLIGHTS + " flights:");

        // TODO Project 3B
        //     create the total number of flight objects and using a switch based on random integer
        //     add the generated flight object to either landing queue, departing queue or the pool of flight objects



    } // end constructor

    /**
     * Add the specified flight to the departing queue.
     * @return true if the flight was successfully added
     *         false if there was no more room in the departing queue
     */
    public boolean addFlightToDepartingQueue(Flight flight)
    {
        // TODO Project 3B

        return false; // THIS IS A STUB
    } // end addFlightToDepartingQueue

    /**
     * Add the specified flight to the landing queue.
     */
    public void addFlightToLandingQueue(Flight flight)
    {
        // TODO Project 3B

    } // end addFlightToLandingQueue

    /**
     * Add the specified flight to the pool of inactive flights.
     */
    public void addFlightToPoolOfFlights(Flight flight)
    {
        // TODO Project 3B
    } // end addFlightToLandingQueue


    /**
     * Simulates queuing to the departing queue one randomly selected flight from the pool of inactive flights.
     * @return selected flight
     *         or null if there is no more inactive flights or there is no room in the departing queue
     */
    public Flight addRandomFlightToDepartingQueue()
    {
        Flight flight = null;

        // TODO Project 3B

        return flight;
    } // end addRandomFlightToDepartingQueue

    /**
     * Simulates plane departure FIFO.
     * The front flight is removed from the departing queue.
     * The priority of the departed flight is updated to the randomly selected new value
     * and the flight is added to the landing queue
     *
     */
    private void planeDepart()
    {

        // TODO Project 3B

    }

    /**
     * Simulates plane landing based on priority.
     * The front flight is removed from the landing queue
     * and the flight is added to the pool of inactive flights
     *
     */
    private void planeLand()
    {

        // TODO Project 3B

    }

    /**
     * The front flight is removed from the departing queue
     * and the flight is added to the pool of inactive flights
     * The cleared flight is not counted as departed
     *
     */
    private void planeClear()
    {

        // TODO Project 3B

    }

    /**
     * Simulates the land/depart/add cycle.
     * If possible, one plane will be departed
     * If possible, one plane will be landed
     * If possible, one flight randomly selected from the pool of inactive flights will be
     *    added to the departing queue
     */
    public void landDepartAdd()
    {
        // taking off

        // TODO Project 3B


        // landing

        // TODO Project 3B



        // adding new flight to the departing queue
        if (this.randomGenerator.nextInt(PERCENT100 + 1) <= PROBABILITY_OF_ADDING_NEW_FLIGHT)
            addRandomFlightToDepartingQueue();
    } // end landDepartAdd

    /**
     * Displays statistics of the simulation at the given time marker
     */
    public void reportAtTimeMarker(int simulationClock)
    {

        // TODO Project 3B

    }

    /**
     * Displays statistics of the finished simulation
     */
    public void simulationReport()
    {

        // TODO Project 3B

    }

    /**
     * All the flights in the departing queue are cleared
     * All the flights in the landing queue are landed
     */
    public void clearAllFlights()
    {

        // TODO Project 3B

    } // end clearAllFlights

    public static void main(String[] args)
    {
        System.out.println("\n\u001B[35m\u001B[1m** Setting up the simulation with sorting mode: BY FLIGHT NUMBER **\u001B[29m");
        SimpleAirportSimulation simulator = new SimpleAirportSimulation(SORT_BY_FLIGHT_NUMBER);

        System.out.println("\n\u001B[35m\u001B[1m** Starting the simulation; duration set to " + simulator.DURATION + " **\u001B[29m");
        for (int simulationClock = 0; simulationClock < simulator.DURATION; simulationClock++)
        {
            simulator.reportAtTimeMarker(simulationClock);
            simulator.landDepartAdd();
        }
        System.out.println("\n\u001B[35m\u001B[1m** After Simulation Report **\u001B[29m\n");
        simulator.simulationReport();
        System.out.println();

        simulator.clearAllFlights();
        System.out.println("\n\u001B[35m\u001B[1m** Final Simulation Report **\u001B[29m\n");
        simulator.simulationReport();
        System.out.println();

        System.out.println("\u001B[35m\u001B[1m** End of simulation with sorting mode: BY FLIGHT NUMBER **\u001B[29m\n");

        System.out.println("\n\u001B[35m\u001B[1m** Setting up the simulation with sorting mode: BY FLIGHT PRORITY **\u001B[29m");

        simulator = new SimpleAirportSimulation(SORT_BY_PRIORITY);

        System.out.println("\n\u001B[35m\u001B[1m** Starting the simulation; duration set to " + simulator.DURATION + " **\u001B[29m");
        for (int simulationClock = 0; simulationClock < simulator.DURATION; simulationClock++)
        {
            simulator.reportAtTimeMarker(simulationClock);
            simulator.landDepartAdd();
        }
        System.out.println("\n\u001B[35m\u001B[1m** After Simulation Report **\u001B[29m\n");
        simulator.simulationReport();
        System.out.println();

        simulator.clearAllFlights();
        System.out.println("\n\u001B[35m\u001B[1m** Final Simulation Report **\u001B[29m\n");
        simulator.simulationReport();
        System.out.println();

        System.out.println("\u001B[35m\u001B[1m** End of simulation with sorting mode: BY FLIGHT PRIORITY **\u001B[29m\n");
    } // end main
} // end SimpleAirportSimulation
