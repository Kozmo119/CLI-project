import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PassengerTest {
    Passenger Mani;

   @BeforeEach
    public void setUp(){
       Mani = new Passenger("Mani", 123,1234);
   }

   @Test
    public void hasName(){
       assertThat(Mani.getName()).isEqualTo("Mani");
   }

   @Test
    public void hasPhoneNumber(){
       assertThat(Mani.getPhoneNumber()).isEqualTo(123);
   }

   @Test
    public void hasID(){
   assertThat(Mani.getId()).isEqualTo(1234);
   }



}
