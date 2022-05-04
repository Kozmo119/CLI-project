import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String destination;
    private int id;
    private List<Passenger> passengers;

    public Flight(String destination, int id) {
        this.destination = destination;
        this.id = id;
        this.passengers = new ArrayList<>();


    }


    public String getDestination() {
        return destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getId(){
        return id;
    }

    public void bookPassenger(Passenger passenger){
        passengers.add(passenger);


    }



    @Override
    public String toString() {
        return "Flight{" +
                "destination='" + destination + '\'' +
                ", id=" + id +
                ", passengers=" + passengers +
                '}';
    }
}
