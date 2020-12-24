package vti.ex2.frontend.question1;

import vti.ex2.backend.question1.mystudent;

import java.util.Scanner;
import vti.ex2.backend.question1.mystudent;
public class program {
    static void menu(){
        System.out.println("------------------------------------");
        System.out.println("1.Nhập 10 học sinh.");
        System.out.println("2.Cả lớp điểm danh.");
        System.out.println("3.Gọi nhóm 1 đi học bài.");
        System.out.println("4.Gọi nhóm 2 đi dọn vệ sinh.");
        System.out.println("5.Exit.");
        System.out.println("------------------------------------");

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mystudent mystudent = new mystudent();
        int n=0;
        do{
            menu();
            System.out.println("Mời bạn chọn: ");
            n = scanner.nextInt();
            switch (n)
            {
                case  1: mystudent.nhap10hocsinh();
                    break;
                case 2: mystudent.diemdanh();
                    break;
                case 3: mystudent.hocbai();
                    break;
                case 4: mystudent.donvesinh();
                    break;
                case 5:
                    System.out.println("GoodBye!!!");
                    break;
            }
        }while(n!=5);
    }
}
