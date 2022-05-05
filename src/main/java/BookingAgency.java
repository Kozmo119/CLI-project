import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


// service to manage a model

import static java.lang.Integer.parseInt;

public class BookingAgency {
    private List<Flight> flights;
    private List<Passenger> allPassengers;
    private Scanner scanner;

    public BookingAgency() {
        this.flights = new ArrayList<>();
        this.allPassengers = new ArrayList<>();
        this.scanner = new Scanner(System.in);

    }

    public List<Passenger> getPassengers() {
        return this.allPassengers;
    }

    public List<Flight> getAllFlights() {
        return this.flights;
    }

    public void start() {
        boolean exit = false;
        int userInput;
        while (!exit) {
            System.out.println("\nAvailable actions:");
            System.out.println("[1] Add new flight");
            System.out.println("[2] Cancel flight");
            System.out.println("[3] Display all flights");
            System.out.println("[4] Add new passenger");
            System.out.println("[5] Book a passenger onto flight");
            System.out.println("[6] Remove a passenger from flight");
            System.out.println("[7] Search flights");
            System.out.println("[0] exit");
            System.out.println("Please input a number indicating which action to take:");

            userInput = scanner.nextInt();

            //System.out.println("\n");
            switch (userInput) {
                case 1:
                    System.out.println("\nAction taken: add new flight");
                    addNewFlight();
                    break;
                case 2:
                    System.out.println("\nAction taken: cancel a flight");
                    cancelFlight();
                    break;
                case 3:
                    System.out.println("\nAction taken: display all available flights");
                    displayAllFlights();
                    break;
                case 4:
                    System.out.println("\nAction taken: add new passenger");
                    addNewPassenger();
                    break;
                case 5:
                    System.out.println("\nAction taken: book passenger onto flight");
                    bookPassenger();
                    break;
                case 6:
                    System.out.println("\nAction taken: remove passenger from flight");
                    removePassenger();
                    break;
                case 7:
                    System.out.println("\nAction taken: search flights");
                    searchFlight();
                    break;
                case 0:
                    System.out.println("\nExiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease enter a valid number\n");
                    break;
            }
        }
    }

    public void addNewFlight() {
        System.out.println("Enter flight destination: ");
        String flightDestination = scanner.next();


        Flight flight = new Flight(flightDestination, FlightRandomIdGene.flightRandomId());
        flights.add(flight);
        System.out.println("Added new " + flight);

    }

    public void cancelFlight() {

        int cancelledFlightId = scanner.nextInt();

        System.out.println("Enter id of cancelled flight:");

        if (flights.stream().anyMatch(flight -> flight.getFlightId() == cancelledFlightId)) {
            flights.removeIf(flight -> flight.getFlightId()==cancelledFlightId);
            System.out.println("Flight with id: " + cancelledFlightId + " removed");
        } else {
            System.out.println("Flight with id " + cancelledFlightId + " does not exist");
        }
    }

    public void displayAllFlights() {
        System.out.println("List of flights: ");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        //System.out.println("\n");
    }

    public void addNewPassenger() {

        System.out.println("Enter passenger name: ");
        scanner.next();
        String passengerName = scanner.nextLine();

        System.out.println("Enter passenger phone number");
        int passengerPhoneNumber;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid phone number");
            scanner.next();
        }
        passengerPhoneNumber = scanner.nextInt();
//        System.out.println("Enter Passengers ID");
//        int passengerID;
//        while (!scanner.hasNextInt()) {
//            System.out.println("Please enter a valid Passengers ID");
//            scanner.next();
//        }
//        passengerID = scanner.nextInt();
        scanner.nextLine(); // Why do we have to add this ? //
        Passenger passenger = new Passenger(passengerName, passengerPhoneNumber, PassengerRandomIdGene.passengerRandomId());
        allPassengers.add(passenger);
        System.out.println(passenger + " created");


    }

    public void bookPassenger() {

        int passengerId;
        int flightId;
        Passenger passenger = null;

        System.out.println("Enter passenger id: ");
        passengerId = scanner.nextInt();

        for (Passenger p : allPassengers) {
            if (p.getId() == passengerId) {
                passenger = p;
            }
        }

        if (passenger != null) {
            System.out.println("Enter flight id: ");
            flightId = scanner.nextInt();
            if (flights.stream().filter(f -> f.getFlightId() == flightId).collect(Collectors.toList()).isEmpty()) {
                System.out.println("Flight with id " + flightId + " does not exist");
            } else {
                for (Flight f : flights) {
                    if (f.getFlightId() == flightId) {
                        f.addPassenger(passenger);
                        System.out.println("added " + passenger + " to " + f + "\n");

                    }
                }

            }

        } else {

            System.out.println("Passenger with id " + passengerId + " does not exist");
        }
    }

    public void removePassenger() {
        int passengerId;
        int flightId;
        System.out.println("Enter passenger Id to remove");
        passengerId = scanner.nextInt();
        Passenger passenger = null;
        for (Passenger p : allPassengers) {
            if (p.getId() == passengerId) {
                passenger = p;
            }
        }

        if (passenger != null) {
            System.out.println("Enter flight Id");
            flightId = scanner.nextInt();
            if (flights.stream().filter(f -> f.getFlightId() == flightId).collect(Collectors.toList()).isEmpty()) {
                System.out.println("Flight does not exist");
            } else {
                for (Flight f : flights) {
                    if (f.getFlightId() == flightId) {
                        f.removePassenger(passenger);
                        System.out.println("removed " + passenger + " from " + f + "\n");

                    }
                }

            }

        } else {

            System.out.println("Passenger does not exist");
        }
    }

    public void searchFlight(){
        List<Flight> matchingFlights;

        System.out.println("Enter desired destination: ");

        scanner.nextLine();
        String searchFlight = scanner.nextLine();

        if (flights.stream().anyMatch(flight -> flight.getDestination().equals(searchFlight))){
            System.out.println("\nFlights available to " + searchFlight + ":");
            for (Flight flight : flights){
                if(flight.getDestination().equals(searchFlight)){
                    System.out.println(flight);
                }
            }
        } else {
            System.out.println("There are no existing flights to " + searchFlight);
        }
    }
}





