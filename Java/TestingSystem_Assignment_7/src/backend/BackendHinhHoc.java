package backend;

import emtity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BackendHinhHoc {
    Scanner scanner = new Scanner(System.in);
    hinhhoc hh;
    HinhTron ht;
    HinhChuNhat hcn;
    ArrayList<hinhhoc> list = new ArrayList<hinhhoc>();
    public void nhapHinhHoc() throws Exceptionhinhhoc {
        int x=0;
        int i=0;
        do {
            i++;
            System.out.println("1.Nhập hình tròn\n2.Nhập hình chữ nhật\n3.Thoat");
            System.out.println("Mời bạn chọn: ");
            x=scanner.nextInt();
            try {
                checkhinhhoc(hinhhoc.getCount());
            }catch (Exceptionhinhhoc e)
            {
                System.out.println(e.getMessage());
                break;
            }

            switch (x)
            {

                case 1: ht = new HinhTron(i);
                    System.out.println("Tạo hình tròn thành công");
                    break;
                case 2:
                    hcn = new HinhChuNhat(2*i,i);
                    System.out.println("Tạo hình chữ nhật thành công");
                    break;
                case 3:
                    System.out.println("bye!!!");
                    break;
                default:
                    System.out.println("Mời bạn nhập lại: ");break;
            }
        }while(x!=3);
    }
    static void checkhinhhoc(int x) throws Exceptionhinhhoc {
        if(x>= Configs.getSo_luong_hinh_toi_da())
        {
            throw new Exceptionhinhhoc("Số lượng hình tối đa là: "+Configs.getSo_luong_hinh_toi_da());
        }
    }
    public void tinhChuViHinhTron(){
        ht.chuvi();
    }
    public void tinhDienTichHinhTron(){
        ht.dientich();
    }
    public void tinhChuViHinhChuNhat(){
        hcn.chuvi();
    }
    public void tinhDienTichHinhChuNhat(){
        hcn.dientich();
    }



}
