package vti.ex2.frontend.question4;
import vti.ex2.*;
import vti.ex2.backend.question4.MyMarth;

import java.util.Scanner;

public class program4 {
    public static void main(String[] args) {
        MyMarth myMarth = new MyMarth();
        Scanner scanner = new Scanner(System.in);
        int x,y;
        System.out.println(" Nhập x và y: ");
        x = scanner.nextInt();
        y=scanner.nextInt();
        System.out.println("SUM: "+ myMarth.sum(x,y));
    }
}
