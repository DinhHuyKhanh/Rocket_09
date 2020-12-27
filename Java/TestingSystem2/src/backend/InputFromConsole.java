package backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputFromConsole {
    public static  Scanner scanner= new Scanner(System.in);

    public void question1(){
        int[] a = new int[3];
        System.out.println("Mời bạn nhập 3 số:");
        System.out.println("Mời bạn nhập a[1]:"); a[0] = scanner.nextInt();
        System.out.println("Mời bạn nhập a[2]:"); a[1] = scanner.nextInt();
        System.out.println("Mời bạn nhập a[3]:"); a[2] = scanner.nextInt();
    }
    public void question2(){
        float[] a = new float[3];
        System.out.println("Mời bạn nhập 2số thực:");
        System.out.println("Mời bạn nhập số thực a[1]:"); a[0] = scanner.nextFloat();
        System.out.println("Mời bạn nhập số thực a[2]:"); a[1] = scanner.nextFloat();
    }
    public void question3(){
        String name;
        System.out.println("Mời bạn nhập họ và tên: "); name = scanner.nextLine();
    }
    public void question4() throws ParseException {
        String s;
        System.out.println("Mời bạn nhập ngày sinh nhật YYYY-MM-dd: "); s= scanner.nextLine();
        // su ly kieu du lieu string ve date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        // in ra ngay thang nam sinh vua nhap:
        System.out.println("Ngày tháng năm sinh của bạn là: " + simpleDateFormat.format(date));
    }
    public void question5(){
        // khác project nên tôi sẽ mô tả cách thức hoạt động.
        /*
        * B1: đầu vào là data info của account
        * B2: sử dụng switch case  or if else đối với positionid;
        * String chucvu;
       vd : positionid =1 ==> if(positionid==1) chucvu = Position.Dev;
       * Sau khi chạy lệnh trên chucvu sẽ được gán = Dev;
       * Ta in ra  chucvu trên Console
        * */
    }
    public void question6(){
        // tuong tu question5;
    }
    public void question7(){
        int a=0;
        do {
            System.out.println("Mời bạn nhập 1 số chẵn: "); a=scanner.nextInt();
        }while(a%2!=0);
    }
    public void menu(){
        System.out.println("1.Thực hiện account.");
        System.out.println("2.Tạo deaprtment.");
    }
    public void question8(){
        int a;
        while(true)
        {
            menu();
            System.out.println("Mời bạn nhập: "); a= scanner.nextInt();
            switch (a)
            {
                case 1:
                    System.out.println("Thực hiện account xong! ");
                    break;
                case 2:
                    System.out.println("Đã tạo thành công department!!! ");
                    break;
                default: question8();
            }
        }
    }
    public void question9(){
        //  tương tự ...
    }
    public void question10(){
    // tương tự
    }

}
