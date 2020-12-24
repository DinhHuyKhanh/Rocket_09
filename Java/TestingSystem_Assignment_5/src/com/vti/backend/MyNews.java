package com.vti.backend;

import com.vti.entity.News;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
    //    c) Tạo chương trình demo có tên là com.vti.backend.MyNews và tạo một menu
//    lựa chọn gồm các mục sau:
//             Insert news
// View list news
// Average rate
// Exit
//    Nếu người dùng chọn 1 từ bàn phím thì tạo một object của
//    class com.vti.entity.News và nhập giá trị cho các thuộc tính Title,
//            PublishDate, Author, Content sau đó yêu cầu người dùng
//            nhập vào 3 đánh giá để lưu vào Rates.
//    Nếu người dùng chọn 2 từ bàn phím thì thực thi method
//    Display().
//    Nếu người dùng chọn 3 từ bàn phím thì thực hiện method
//    Calculate() để tính đánh giá trung bình, sau đó thực thi
//    method Display().
//    Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương
//    trình.
    public Scanner scanner = new Scanner(System.in);
    News news;
    ArrayList<News> list = new ArrayList<News>();

    public void insert(){
        news = new News();
        System.out.println("Mời bạn nhập id mới: ");
        news.setId(scanner.nextInt());

        System.out.println("Mời bạn nhập title mới: ");
        scanner.nextLine();
        news.setTitle(scanner.nextLine());

        System.out.println("Mời bạn nhập Publish Date mới: ");
        news.setPublishDate(scanner.nextLine());

        System.out.println("Mời bạn nhập author mới: ");
        news.setAuthor(scanner.nextLine());

        System.out.println("Mời bạn nhập Content mới: ");
        news.setContent(scanner.nextLine());

        System.out.println("Mời bạn nhập 3 đánh giá: ");

        int[] rate = new int[3];
        for(int i=0;i<3;i++)
        {
            System.out.println(" Đánh giá "+(i+1)+": ");
            rate[i]= scanner.nextInt();
        }
        news.setRates(rate);
        list.add(news);
    }
    public void hienthongtin(){
        System.out.println("Thông tin: ");
        for(News i: list)
        {
           i.Display();
        }
    }
    public void tinhCalculate(){
        news.Calculate();
        news.Display();
    }

}
