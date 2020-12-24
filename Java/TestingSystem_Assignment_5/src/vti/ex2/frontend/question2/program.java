package vti.ex2.frontend.question2;

import vti.ex2.backend.question2.MyStudent;

import java.sql.SQLOutput;
import java.util.Scanner;

public class program {
    static void menu(){
        System.out.println("1. InputInfo");
        System.out.println("2. ShowInfo");
        System.out.println("3. Exit");
    }
    public static void main(String[] args) {
        int x=0;
        Scanner scanner = new Scanner(System.in);
        MyStudent myStudent= new MyStudent();
        do {
            menu();
            System.out.println("Mời bạn chọn: ");
            x = scanner.nextInt();
            switch (x)
            {
                case 1:
                        myStudent.InputInfo();
                        break;
                case 2:
                        myStudent.showInfo();
                        break;
                case 3:
                    System.out.println("Good bye!!! ");
                    break;
            }

        } while(x!=3);
    }
}
