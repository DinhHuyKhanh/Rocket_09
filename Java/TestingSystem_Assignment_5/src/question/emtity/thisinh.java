package question.emtity;

import javax.swing.*;

public class thisinh {
    private  int sbd;
    private String diachi;
    private String hoten;
    private  int mucuutien;
    private String[] monhoc;

    public  thisinh(){

    }
    public thisinh(int sbd, String  hoten, String diachi, int mucuutien)
    {
        this.sbd = sbd;
        this.hoten = hoten;
        this.diachi = diachi;
        this.mucuutien = mucuutien;
    }

    public int getSbd() {
        return sbd;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public int getMucuutien() {
        return mucuutien;
    }

    public void setSbd(int sbd) {
        this.sbd = sbd;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setMucuutien(int mucuutien) {
        this.mucuutien = mucuutien;
    }

    public String[] getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String[] monhoc) {
        this.monhoc = monhoc;
    }
    public void hien(){
        System.out.println("Số báo danh: "+getSbd());
        System.out.println("Họ và tên : "+getHoten());
        System.out.println("Địa chỉ:" +getDiachi());
        System.out.println("Môn học:" + monhoc[0] + " "+ monhoc[1] +" " + monhoc[2]);
    }

}
