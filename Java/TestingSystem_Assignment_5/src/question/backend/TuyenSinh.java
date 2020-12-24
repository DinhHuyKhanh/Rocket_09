package question.backend;

import question.emtity.ITuyenSinh;
import question.emtity.thisinh;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {

    thisinh thisinh ;
    ArrayList<thisinh>  list = new ArrayList<thisinh>();
    public Scanner scanner = new Scanner(System.in);


    @Override
    public void insert() {
        thisinh = new thisinh();
        System.out.println("Mời bạn nhập Số báo danh mới: ");
        thisinh.setSbd(scanner.nextInt());

        scanner.nextLine();
        System.out.println("Mời bạn nhập Họ và tên: ");
        thisinh.setHoten(scanner.nextLine());

        System.out.println("Mời bạn nhập địa chỉ: ");
        thisinh.setDiachi(scanner.nextLine());

        System.out.println("Mời bạn nhập khối thi:");
        String khoi;  khoi = scanner.nextLine();
        String[] monhoc = new String[3];
        if(khoi.equals("A")){
            monhoc[0] = "Toán";
            monhoc[1] = "Lý";
            monhoc[2] = "Hóa";
        }
        if(khoi.equals("B"))
        {
            monhoc[0] = "Toán";
            monhoc[1] = "Hóa";
            monhoc[2] = "Sinh";
        }
        if(khoi.equals("C"))
        {
            monhoc[0] = "Văn";
            monhoc[1] = "Sử";
            monhoc[2] = "Địa";
        }
        thisinh.setMonhoc(monhoc);
        list.add(thisinh);
    }

    @Override
    public void viewlist() {
        for(thisinh x: list)
        {
            x.hien();
        }
    }


    @Override
    public void searchsbd() {
         int sbd;
         System.out.println("Mời bạn nhập SBD cần tìm: ");
         sbd= scanner.nextInt();

        for(int i=0;i<list.size();i++)
        {
            if(sbd == list.get(i).getSbd()){
                list.get(i).hien();
            }
        }
    }

    @Override
    public void exit() {
        System.out.println("Goodbye <3 Mãi iuuu !!!");
    }
}
