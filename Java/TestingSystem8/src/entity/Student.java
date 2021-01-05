package entity;

public class Student {
    private int id;
    private String name;
    private static int count;

    public Student(String name) {
        this.name = name;
        this.id = ++count;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student(){

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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public void in(){
        System.out.println("id: "+getId());
        System.out.println("name: "+getName());
    }
}
