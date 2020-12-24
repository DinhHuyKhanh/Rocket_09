package vti.ex2.frontend.question3;
import  vti.ex2.entity.question3.*;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        hinhchunhat hcn;
        HinhVuong hv ;
        Scanner scanner = new Scanner(System.in);
        float dai=0, rong=0;
        for(int i=0;i<5;i++)
        {
            System.out.println("Nhập chiều dài , chiều rộng: ");
            dai = scanner.nextFloat();
            rong = scanner.nextFloat();
            hv = new HinhVuong();
            hv.tinhchuvi(dai,rong);
            hv.tinhdientich(dai,rong);
        }

    }
}
