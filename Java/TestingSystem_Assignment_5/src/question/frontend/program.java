package question.frontend;

import question.backend.TuyenSinh;

import java.util.Scanner;

public class program {

    static void menu(){
        System.out.println("1. Insert.");
        System.out.println("2. View.");
        System.out.println("3. Search SBD.");
        System.out.println("4. Exit.");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TuyenSinh tuyenSinh = new TuyenSinh();
        int n=0;

        do{
            menu();
            System.out.println("Mời bạn chọn: ");
            n = scanner.nextInt();

            switch (n)
            {
                case 1: tuyenSinh.insert();
                    break;
                case 2: tuyenSinh.viewlist();
                    break;
                case 3: tuyenSinh.searchsbd();
                    break;
                case 4: tuyenSinh.exit();
                    break;
            }

        }while(n!=4);
    }

}
