package models;

public class Bussines {
    private String id;
    private String name;
    private String addres;
    private String city;

    public Bussines(String id, String name, String addres, String city) {
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Business {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + addres + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}
