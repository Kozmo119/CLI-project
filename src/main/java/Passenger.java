import java.io.Serializable;

public class Passenger implements Serializable {
    private String name;
    private String phoneNumber;
    private int id;

    public Passenger(String name, String phoneNumber, int id){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", id=" + id +
                '}';
    }
}
