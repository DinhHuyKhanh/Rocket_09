package com.vti.frontend;

import com.vti.backend.MyNews;

import java.util.Scanner;

public class program {


    public static void menu(){
        System.out.println("-------------------------------");
            System.out.println("1. Nhập thông tin.");
            System.out.println("2.Hiện thông tin.");
            System.out.println("3. Đánh giá trung bình.");
            System.out.println("4. Exit.");
        System.out.println("-------------------------------");
    }


    public static void main(String[] args) {
        MyNews myNews = new MyNews();
        Scanner scanner = new Scanner(System.in);
        int x=0;
        do {
            menu();
            System.out.println(" Mời bạn chọn: "); x = scanner.nextInt();
            switch(x)
            {
                case 1: myNews.insert();
                    break;
                case 2: myNews.hienthongtin();
                    break;
                case 3: myNews.tinhCalculate();
                    break;
                case 4:
                    System.out.println("Goodbye! <3 ");
                    break;
            }
        }while(x!=4);
    }
}
