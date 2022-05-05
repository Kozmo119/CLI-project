import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightRandomIdGene {
    private static List<Integer> allId = new ArrayList<>();

    public static int flightRandomId() {
        Random random = new Random();
        int randomId = random.nextInt(1, 10001);
        if (allId.stream().anyMatch(id -> id == randomId)) return flightRandomId();
        allId.add(randomId);
        return randomId;
    }

}
