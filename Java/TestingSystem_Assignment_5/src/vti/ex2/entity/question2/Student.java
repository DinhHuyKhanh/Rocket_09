package vti.ex2.entity.question2;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends  Person{
    private float diemtb;
    private int masv;
    private String email;
    Scanner scanner = new Scanner(System.in);



    public Student(){
        super();
    }
    public Student(int masv,String email, float diemtb)
    {
        super();
        this.masv = masv;
        this.email = email;
        this.diemtb = diemtb;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getDiemtb() {
        return diemtb;
    }

    public void setDiemtb(float diemtb) {
        this.diemtb = diemtb;
    }

    public void inputInfor(){
        System.out.println("Mời bạn nhập thông tin sinh viên mới : ");
        System.out.println("Mời bạn nhập Mã SV: ");
        this.masv = scanner.nextInt();

        super.inputInfo();

        scanner.nextLine();
        System.out.println("Mời bạn nhập email : ");
        this.email = scanner.nextLine();

        System.out.println("Mời bạn nhập điểm trung bình: ");
        this.diemtb = scanner.nextFloat();
    }
    public void showInfo()
    {
        System.out.println("Thông tin sinh viên: " );

        System.out.println("Mã sv: "+ getMasv());
        super.showInfo();
        System.out.println("Email :"+getEmail());
        System.out.println("Điểm trung bình :"+getDiemtb());
    }

    public void xethocbong(){
        if(getDiemtb()>8)
            System.out.println("Điểm trung bình là: "+getDiemtb()+" đạt được học bổng.");
        else
            System.out.println("Điểm trung bình là: "+ getDiemtb() +" không đạt học bổng");
    }
}
