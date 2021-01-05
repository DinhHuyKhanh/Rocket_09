package entity.Exercise3;

public class Employee <T extends  Number>{
    private int id;
    private String name;
    private T[] salaries;

    public Employee(int id, String name, T[] salaries) {
        this.id = id;
        this.name = name;
        this.salaries = salaries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T[] getSalaries() {
        return salaries;
    }

    public void setSalaries(T[] salaries) {
        this.salaries = salaries;
    }
}
