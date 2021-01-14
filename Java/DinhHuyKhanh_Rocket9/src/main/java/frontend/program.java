package frontend;

import backend.presentationlayer.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Description
 * @author: Đinh Huy Khánh
 * @creat_date: 13-1-2021
 * @modifer:
 * @modifer_date:
 * */
public class program {
    static void menu(){
        System.out.println("1.In thông tin của manager và employee của project ID");
        System.out.println("2.Các manager của các dự án");
        System.out.println("3.Exit");
    }
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        Byte x;
        boolean status=false;
        do {
            System.out.println("Mời bạn Login");
            status = controller.question4();

        }while(status==false);

        if(status == true)
        {
            do {
                menu();
                System.out.println("Mời bạn chọn: ");
                x = scanner.nextByte();
                switch (x)
                {
                    case 1: controller.question2();
                            break;
                    case 2: controller.question3();
                            break;
                    case 3:
                        System.out.println("Good bye !");
                        System.exit(0);
                    default:
                        System.out.println("Mời bạn chọn lại!");
                }
            }while(x!=3);
        }
    }
}
