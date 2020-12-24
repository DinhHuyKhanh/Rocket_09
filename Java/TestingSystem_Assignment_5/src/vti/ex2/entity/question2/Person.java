package vti.ex2.entity.question2;

import java.util.Scanner;

public class Person {
    private String hoten;
    private boolean gioitinh;
    private String ngaysinh;
    private String diachi;
    private Scanner  scanner = new Scanner(System.in);

    public Person(){

    }
    public Person(String hoten, boolean gioitrinh, String ngaysinh, String diachi){
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void inputInfo(){
        System.out.println("Mời nhập họ và tên: ");
        this.hoten = scanner.nextLine();

        System.out.println("Mời nhập giới tính ( nữ :false && nam:true) : ");
        this.gioitinh = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Mời nhập ngày tháng năm sinh: ");
        this.ngaysinh = scanner.nextLine();

        System.out.println("Mời nhập địa chỉ: ");
        this.diachi = scanner.nextLine();
    }

    public void showInfo(){
        System.out.println("Họ và tên: "+getHoten());
        System.out.println("Giới tính: " + ((isGioitinh())?"Nam":"Nữ"));
        System.out.println("Ngày tháng năm sinh: "+getNgaysinh());
        System.out.println("Địa chỉ: "+getDiachi());
    }


}
