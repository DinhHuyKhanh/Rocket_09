package TestingSystem4.backend.Exercise4;

import java.util.Scanner;

public class Student {
    private int id;
    private  String name;
    private String hometown;
    private float diemhocluc;

    public Student(){

    }
    public Student(int id, String name, String hometown) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
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

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public float getDiemhocluc() {
        return diemhocluc;
    }

    public void setDiemhocluc(float diemhocluc) {
        this.diemhocluc = diemhocluc;
    }

    public float congDiem(int a){
        return this.diemhocluc=(float)(diemhocluc+a);
    }

    public void showinfo(){
        System.out.println("id: "+getId());
        System.out.println("Name: "+getName());
        System.out.println("Hometown: "+getHometown());
        System.out.println("Điểm học lực: "+getDiemhocluc());
    }
    public void insert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id: ");
        id = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Nhập Name: ");
        name = scanner.nextLine();

        System.out.println("Nhập Hometown: ");
        hometown = scanner.nextLine();


    }
}
