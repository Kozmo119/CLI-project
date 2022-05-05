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

    public List<Passenger> getPassengers(){
        return this.allPassengers;
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





