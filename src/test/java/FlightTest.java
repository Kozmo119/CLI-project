import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {
    Passenger Mani;
    Passenger Ed;
    Flight plane1;

    @BeforeEach
    public void setUp(){
        Mani = new Passenger("Mani", 12, 13);
        Ed = new Passenger("Ed", 14, 16);
        plane1 = new Flight("Wellington", 134);
    }

    @Test
    public void hasName(){
        assertThat(plane1.getDestination()).isEqualTo("Wellington");
    }

    @Test
    public void hasId(){
        assertThat(plane1.getFlightId()).isEqualTo(134);
    }

    @Test
    public void canAddPassenger(){
        plane1.addPassenger(Mani);
        plane1.addPassenger(Ed);
        assertThat(plane1.getPassengers().size()).isEqualTo(2);
    }

    @Test
    public void canRemovePassenger(){
        plane1.addPassenger(Ed);
        plane1.addPassenger(Mani);
        assertThat(plane1.getPassengers().size()).isEqualTo(2);

        plane1.removePassenger(Ed);
        assertThat(plane1.getPassengers().size()).isEqualTo(1);
    }
}
