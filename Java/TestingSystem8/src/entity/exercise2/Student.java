package entity.exercise2;

import java.util.Comparator;

public class Student{
    private int id;
    private String name;
    private String date;
    private float diem;

    public Student(int id, String name, String date, float diem) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.diem = diem;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    public void in(){
        System.out.println("id: "+ id);
        System.out.println("Name: " +name);
        System.out.println("Ngày sinh: "+date);
        System.out.println("Điểm: "+diem);
    }



}
