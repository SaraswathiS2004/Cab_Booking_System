package dto;

public class DriverDetails {
    private int id;
    private String address;
    private int age;
    private int Experience;
    private String cab_Name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getCab_Name() {
        return cab_Name;
    }

    public void setCab_Name(String cab_Name) {
        this.cab_Name = cab_Name;
    }
}
