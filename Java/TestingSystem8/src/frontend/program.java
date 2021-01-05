package frontend;

import backend.exercise1.question1.Studentchucnang;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        int x=0;
        Scanner scanner = new Scanner(System.in);
        Studentchucnang std = new Studentchucnang();

//        do{
//            menu();
//            System.out.println("Mời bạn nhập: ");
//            x = scanner.nextInt();
//            switch (x){
//                case 1: std.insert();
//                    break;
//                case 2:
//                    std.showinf();
//                    break;
//                case 3: std.layphantuthu4();
//                    break;
//                case 4:
//                    std.firstAndLast();
//                    break;
//                case 5:
//                    std.addFirstStudent();
//                    break;
//                case 6:
//                    std.addLastStudent();
//                    break;
//                default:
//                    System.out.println("mời bạn chọn lại!!!");
//
//            }
//        }while(x!=6);
    }
    static void menu(){
        System.out.println("1.Tạo entity.Student.");
        System.out.println("2.In ra danh sách student.");
        System.out.println("3.In ra học sinh đầu và cuối danh sách");
        System.out.println("4.Thêm học sinh đầu danh sách");
        System.out.println("5.Thêm học sinh cuối danh sách");
        System.out.println("6. Exit!!!");
    }
    }

