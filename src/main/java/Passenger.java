public class Passenger {
    private String name;
    private int phoneNumber;
    private int id;

    public Passenger(String name, int phoneNumber, int id){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
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
