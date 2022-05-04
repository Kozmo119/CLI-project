import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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


    public void addFlight(String destination, int id) {
        Flight flight = new Flight(destination, id);
        flights.add(flight);
    }

    public void displayFlights() {
        System.out.println(flights);
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

        System.out.println("Enter Passengers ID");
        int passengerID;
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid Passengers ID");
            scanner.next();

        }
        passengerID = scanner.nextInt();
        scanner.nextLine(); // Why do we have to add this ? //
        if (allPassengers.stream().filter(passenger -> passenger.getId() == passengerID).collect(Collectors.toList()).isEmpty()) {
            Passenger passenger = new Passenger(passengerName, passengerPhoneNumber, passengerID);
            System.out.println(passenger + " added");
            allPassengers.add(passenger);
        } else {
            System.out.println("Passenger with " + passengerID + " ID already exists");
        }
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





