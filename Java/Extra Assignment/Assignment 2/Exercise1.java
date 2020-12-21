import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
   static public Scanner scanner = new Scanner(System.in);

    static void chuyenCentiSangFoot(float centi)
    {
        double foot,inch;
        inch= centi/2.54;
        foot= inch/12;
        System.out.printf("\n foot = %.2f" , foot);
        System.out.printf("\n inches =%.2f" , inch);
    }
    static void chuyenGiaySangDate(int giay)
    {
        int h,m,s;
        h= giay/3600;
        m=(giay-h*3600)/60;
        s=(giay-h*3600 - m*60);
        String date1= h+":"+m+":"+s;
        System.out.println("\n hh:mm:ss ="+date1);
    }

    // question 3;
    static void timkiemSoMaxvaMin()
    {

        int arr[] = new int[4];
              for(int i=0;i<4;i++)
              {
                  System.out.printf("\n nhap arr[%d]=",i);
                  arr[i]= scanner.nextInt();
              }
              int smax = arr[0], smin =arr[0];
              for(int i=1;i<4;i++)
              {
               if(arr[i]>smax) smax = arr[i];
               if(arr[i]<smin) smin = arr[i];
              }
              System.out.printf("Min = %d \nMax =%d",smin,smax);
    }
    static void hieuHaiso()
    {
        int a,b;
        System.out.print("Nhap a va b: \n");
        a = scanner.nextInt();
        b=scanner.nextInt();
        if(a>b) System.out.println("Số thứ nhất lớn hơn số thứ hai");
        else if(a<b) System.out.println("Số thứ nhất bé hơn số thứ hai");
        else System.out.println("số thứ nhất bằng số thứ hai");
    }
    static void  chiaDu()
    {
        int a,b;
        System.out.println("Nhap a và b: ");
        a = scanner.nextInt();
        b=scanner.nextInt();
        if(a%b==0) System.out.println(" a chia hết cho b");
        else System.out.println("a không chia hết cho b va bi du ra :" + a%b);
    }
    static void xeploaiHocLuc()
    {
        float diemToan,diemLy,diemHoa,diem;
        System.out.println(" Nhap diem Toan: "); diemToan = scanner.nextFloat();
        System.out.println(" Nhap diem Ly: "); diemLy = scanner.nextFloat();
        System.out.println(" Nhap diem Hoa: "); diemHoa = scanner.nextFloat();
        diem=((diemToan*2)+diemLy+diemHoa)/4;
        if(diem>=9) System.out.println("Với số điểm là : "+ diem + "Đạt loại xuất sắc");
        else if(diem>=8 && diem<9) System.out.println("Với số điểm là : "+ diem +" Đạt loại giỏi");
        else if(diem>=7 && diem<8) System.out.println("Với số điểm là : "+ diem +" Đạt loại khá");
        else if(diem>=6 && diem<7) System.out.println("Với số điểm là : "+ diem +" Đạt loại trung bình khá");
        else if(diem>=5 && diem<6) System.out.println("Với số điểm là : "+ diem +" Đạt loại trung bình");
        else  System.out.println("Với số điểm là : "+ diem +" Đạt loại kém");
    }


}
