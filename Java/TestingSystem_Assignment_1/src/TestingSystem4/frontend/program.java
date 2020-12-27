package TestingSystem4.frontend;

import TestingSystem4.backend.Exercise4.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class program {
        static void menu(){
            System.out.println("1. Nhập info");
            System.out.println("2. Hiện");
            System.out.println("3. Nhập điểm");
            System.out.println("4. Cộng điểm");
            System.out.println("5.Exit");
        }
    public static void main(String[] args) {
        Student student = new Student() ;
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<Student>();
        int x=0;
        while(x!=5)
        {
            menu();
            System.out.println("Mời bạn chọn: ");
            x = scanner.nextInt();
            switch(x){
                case 1:
                    student.insert();
                    break;
                case 2:
                    student.showinfo();
                    break;
                case 3:
                    System.out.println("Mời bạn nhập điểm: ");
                    student.setDiemhocluc(scanner.nextFloat());
                    student.showinfo();
                    break;
                case 4:

                    System.out.println("điểm học lực hiện tại: "+student.getDiemhocluc());
                    System.out.println("Mời bạn nhập số điểm muốn cộng thêm: ");
                    student.congDiem(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Good Bye <3! ");
                    break;
            }
        }
    }
}
