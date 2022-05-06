import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PassengerRandomIdGene {
    private static List<Integer> allId = new ArrayList<>();

    public static int passengerRandomId() {
        Random random = new Random();
        int randomId = random.nextInt(1, 10001);
        if (allId.stream().anyMatch(id -> id == randomId)) return passengerRandomId();
        allId.add(randomId);
        return randomId;
    }
}
