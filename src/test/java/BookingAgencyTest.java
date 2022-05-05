import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookingAgencyTest {
    BookingAgency bookingAgency;
    Flight flight1;
    Flight flight2;
    Passenger passenger1;



    @BeforeEach
    public void setUp(){
        bookingAgency = new BookingAgency();
        flight1 = new Flight("Spain",123241);
        flight2 = new Flight("London",12211);
        passenger1 = new Passenger("Mani", 123213, 5673);
        bookingAgency.getAllFlights().add(flight1);
    }

    @Test

    public void canGetAllFlights(){
        assertThat(bookingAgency.getAllFlights().size()).isEqualTo(1);
    }

    @Test

    public void canCancelFlight(){
        bookingAgency.getAllFlights().remove(flight1);
        assertThat(bookingAgency.getAllFlights().size()).isEqualTo(0);
    }

}
