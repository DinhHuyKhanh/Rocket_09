package backend.POJO;


public class DepartmentConvert {
    private short id;
    private String name;
    private String Address;

    public DepartmentConvert(short id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentConvert(short id, String name, String address) {
        this.id = id;
        this.name = name;
        this.Address = address;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "DepartmentConvert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
