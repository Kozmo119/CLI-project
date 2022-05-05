import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String destination;
    private int flightId;
    private List<Passenger> passengers;

    public Flight(String destination, int flightId) {
        this.destination = destination;
        this.flightId = flightId;
        this.passengers = new ArrayList<>();

        // a comment test

    }

    public String getDestination() {
        return destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getFlightId(){
        return flightId;
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);


    }

    public void removePassenger(Passenger passenger){
        passengers.remove(passenger);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "destination='" + destination + '\'' +
                ", flightId=" + flightId +

                '}';
    }
}
