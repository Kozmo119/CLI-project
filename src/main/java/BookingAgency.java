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

    public void bookPassenger() {
        int passengerId;
        int flightId;
        System.out.println("Enter passenger Id");
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
                        f.addPassenger(passenger);
                        System.out.println("added " + passenger + " to " + f);

                    }
                }

            }

        } else {

            System.out.println("Passenger does not exist");
        }
    }


    public void removePassenger(){
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
                        System.out.println("removed " + passenger + " from " + f);

                    }
                }

            }

        } else {

            System.out.println("Passenger does not exist");
        }
    }



    public void addNewFlight() {
        System.out.println("Provide a flight destination: ");
        String flightDestination = scanner.next();


        Flight flight = new Flight(flightDestination, FlightRandomIdGene.flightRandomId());
        flights.add(flight);
        System.out.println(flight);
    }

    public void displayAllFlights() {
        System.out.println(flights);
    }


    public List<Flight> getAllFlights(){
        return this.flights;
    }


    public void addNewPassenger() {
        boolean hasEnteredPhoneNumber = false;
        // Scanner scanner2 = new Scanner(System.in);       // Needs new scanner otherwise it skips the input when adding a second passengers name /
        System.out.println("Enter Passengers name");
        String passengerName = scanner.nextLine();
        System.out.println("Enter Passengers phone number");
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
//
//        }
//        passengerID = scanner.nextInt();
        scanner.nextLine(); // Why do we have to add this ? //
        Passenger passenger = new Passenger(passengerName, passengerPhoneNumber, PassengerRandomIdGene.passengerRandomId());
        allPassengers.add(passenger);
        System.out.println(passenger + " created");


    }
//       private int userInputInt(){
//
//           System.out.println("Please enter a phone number");
//            while (!scanner.hasNextInt()) {
//                System.out.println("Please enter a valid phone number");
//                scanner.next();
//    }
//
////        String input = scanner.nextLine();
////        return parseInt(input);


}


//System.out.println("Add a destination");
//String destination = scanner.nextLine();
//int userGuess = scanner.nextInt();
//String userName = scanner.nextLine();





