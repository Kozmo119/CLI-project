public class Main {
    public static void main(String[] args) {

        BookingAgency bookingAgency = new BookingAgency();
//        bookingAgency.addNewPassenger();
        bookingAgency.addNewPassenger();
        bookingAgency.addNewFlight();
        bookingAgency.addNewFlight();
        bookingAgency.displayAllFlights();
        bookingAgency.bookPassenger();
    }
}
