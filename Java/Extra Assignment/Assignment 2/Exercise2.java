import java.util.*;
import java.lang.String;

public class Exercise2 {
    public static Scanner scanner = new Scanner(System.in);

    /*
    * Question 1:
    Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
    Hãy liệt kê các phần tử xuất hiện trong dãy đúng một lần
    * */
    static void lietkeXuatHien1Lan() {
        int n;
        System.out.println("Nhap n: ");
        n = scanner.nextInt();
        int arr[] = new int[n];

        System.out.println(" nhap mang arr");
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap a[%d]:", i);
            arr[i] = scanner.nextInt();
        }

        System.out.print("Output: ");
        for (int i = 0; i < n; i++) {
            int dem = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) dem++;
            }
            if (dem == 1) {
                System.out.printf("%5d", arr[i]);
            }
        }
    }

    /* Question 2:
         Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1.
         Hãy liệt kê các phần tử xuất hiện trong dãy đúng 2 lần. */
    static void lietkeXuatHien2Lan() {
        int n;
        System.out.println("Nhap n: ");
        n = scanner.nextInt();
        int arr[] = new int[n];

        System.out.println(" nhap mang arr");
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap a[%d]:", i);
            arr[i] = scanner.nextInt();
        }

        System.out.print("Output: ");
        for (int i = 0; i < n - 1; i++) {
            int dem = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) dem++;
            }
            if (dem == 1) {
                System.out.printf("%5d", arr[i]);
            }
        }
    }

    /* Question 3:
      Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
          In ra màn hình số lần xuất hiện của các phần tử. */
    static void demSoLanXuatHien() {
        int n;
        System.out.println("Nhap n: ");
        n = scanner.nextInt();
        int arr[] = new int[n];

        System.out.println(" nhap mang arr");
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap a[%d]:", i);
            arr[i] = scanner.nextInt();
        }

        System.out.print("Output: ");
        for (int i = 0; i < n; i++) {
            int dem = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) dem++;
            }
            System.out.printf("%5d", dem);
        }
    }

    /* Question 4:
Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ.
Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32 */
    static void tinhtong1so() {
        int n, tong = 0;
        System.out.println("Nhap 1 so bat ky : ");
        n = scanner.nextInt();
        String s = String.valueOf(n);
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            int number = Integer.parseInt(String.valueOf(s1[i]));
            tong = tong + number;
        }
        System.out.printf("\n Outpit : tong = %d", tong);
    }

    /*
    * Question 5:
Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố
Ví dụ: Số 28 được phân tích thành 2 x 2 x 7
    * */
    static void phantichSonguyenTo() {
        int n;
        System.out.println("Nhap so muon phan tach: ");
        n = scanner.nextInt();
        System.out.print("Output: ");
        for (int i = 2; i <= n; i++) {
            int dem = 0;
            while (n % i == 0) {
                dem++;
                n /= i;
            }
            if (dem != 0) {
                System.out.print(i);
                if (dem > 1) System.out.print("^" + dem);
                if (n > i) System.out.print("*");
            }
        }
    }

    /* Question 6:
Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n cho trước */
    static int soNguyenTo(int x) {
        if (x < 2) return 0;
        for (int i = 2; i <= Math.sqrt((float) x); i++) {
            if (x % i == 0) return 0;
        }
        return 1;
    }

    static void timSoNguyenTo() {
        int n;
        System.out.println("Nhap so N: ");
        n = scanner.nextInt();
        System.out.print("Output:");
        for (int i = 2; i <= n; i++) {
            if (soNguyenTo(i) == 1) System.out.printf("%5d", i);
        }
    }

    /* Viết chương trình liệt kê n số nguyên tố đầu tiên */

    static void nSoNguyenToDauTien() {
        int n, dem = 0;
        System.out.print("Nhap n: ");
        n = scanner.nextInt();
        int i = 2;
        System.out.print("Output:");
        while (n != dem) {
            if (soNguyenTo(i) == 1) {
                System.out.printf("%5d", i);
                dem++;
            }
            i++;
        }
    }

    /* Viết chương trình tìm ước số chung lớn nhất, bội số chung nhỏ nhất của hai số
tự nhiên a và b.
*/
    static void UocMaxAndBoiMin() {
        int uocMax = 0, boiMin;
        int a, b, n;
        System.out.print("Nhap a và b:");
        a = scanner.nextInt();
        b = scanner.nextInt();
        if (a >= b) n = b;
        else n = a;
        System.out.print("Output: Uoc max and Boi Min la: ");
        for (int i = n / 2; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                uocMax = i;
                System.out.printf("%5d", i);
                break;
            }
        }
        boiMin = (a * b) / uocMax;
        System.out.printf("%5d", boiMin);
    }

    static void fibonacci() {
        int n;
        System.out.print("Nhap n:");
        n = scanner.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.print("Output: ");
        for (int i = 0; i <= n; i++) {
            System.out.printf("%5d", arr[i]);
        }
    }

    /* Question 10:
Một số được gọi là số thuận nghịch độc nếu ta đọc từ trái sang phải hay từ
phải sang trái số đó ta vẫn nhận được một số giống nhau.
Hãy liệt kê tất cả các số thuận nghịch độc có sáu chữ số (Ví dụ số: 558855). */
    static int kiemtrasoThuanNghich(int x) {
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        int leng;
        if (ch[ch.length - 1] == '0') leng = ch.length - 1;
        else leng = ch.length;
        String s1 = "";
        for (int i = leng - 1; i >= 0; i--) {
            s1 = s1 + ch[i];
        }
        x = Integer.parseInt(s1);
        return x;
    }

    static void soThuanNghich() {
        System.out.println("Output:");

        for (int i = (int) 100000; i < 1000000; i++) {
            if (i == kiemtrasoThuanNghich(i)) System.out.println(i);
        }
    }

    static void hoanvi() {
        int n;
        System.out.print("Nhap n: ");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Output: ");
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
            System.out.printf("%3d", arr[i]);
        }
        // tim nhung hoan vi con lai bang cach ap dung thuat toan Sinh
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                int j;
                for (j = n - 1; j >= i; j--) {
                    if (arr[j] > arr[i - 1]) {
                        int tg = arr[j];
                        arr[j] = arr[i - 1];
                        arr[i - 1] = tg;
                        break;
                    }
                }
                //
                for (j = n - 1; j > (n - 1 + i) / 2; j--) {
                    int tg = arr[i + n - 1 - j];
                    arr[i + n - 1 - j] = arr[j];
                    arr[j] = tg;
                }
                //
                System.out.print("\n");
                for (j = 0; j < n; j++) {
                    System.out.printf("%3d", arr[j]);
                }
                i = n;
            }
        }
    }

    /*
    *Question 12:
Nhập số liệu cho 2 dãy số thực a0 , a1 ,..., am-1 và b0 , b1 ,..., bn-1. Giả sử
cả 2 dãy này đã được sắp theo thứ tự tăng dần.
Hãy tận dụng tính sắp xếp của 2 dãy và tạo dãy c0 , c1 ,..., cm+n-1 là hợp của
2 dãy trên, sao cho dãy ci cũng có thứ tự tăng dần .
    * */


    static void hopcua2day() {
        int m, n;
        System.out.print("Nhap m va n: ");
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[] arr = new int[m];
        int[] brr = new int[n];
        int[] c = new int[m + n];
        // nhap 2 mang a va b
        for (int i = 0; i < m; i++) {
            // System.out.printf("\n Nhap arr%d]",i);
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            //System.out.printf("\n Nhap brr[%d]",i);
            brr[i] = scanner.nextInt();
        }
        // ghep 2 mang a va b
        int a = 0, b = 0;
        int i = 0;
        while (true) {
            if (a < m && b < n) {
                if (arr[a] < brr[b]) {
                    c[i] = arr[a];
                    a++;
                    i++;
                } else {
                    c[i] = brr[b];
                    b++;
                    i++;
                }
            } else {
                if (a == m) {
                    for (int k = b; k < n; k++) {
                        c[i] = brr[k];
                        i++;
                    }
                    break;
                } else if (b == n) {
                    for (int k = a; k < m; k++) {
                        c[i] = arr[k];
                        i++;
                    }
                    break;
                }
            }
        }
        System.out.print("Output:");
        for (i = 0; i < m + n; i++) {
            System.out.printf("%4d", c[i]);
        }
    }

    //    Question 13:
//    Nhập số n và dãy các số thực a0 , a1 ,..., an-1. Không đổi chỗ các phần tử và
//    không dùng thêm mảng số thực nào khác (có thể dùng mảng số nguyên nếu
//            cần)
//    Hãy cho hiện trên màn hình dãy trên theo thứ tự tăng dần
    static int check(int x, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return 0;
        }
        return 1;
    }

    static void sapxepSoThuc() {
        int n;
        System.out.println("INPUT");
        n = scanner.nextInt();
        float[] a = new float[n + 1];
        int[] b = new int[n + 1];
        // nhap
        for (int i = 1; i < n + 1; i++) {
            a[i] = scanner.nextFloat();
        }

        // tim
        for (int i = 1; i < n + 1; i++) {
            int vt = 0;
            float smax = 0;
            for (int j = 1; j < n + 1; j++) {
                if (a[j] > smax && check(j, b) == 1) {
                    smax = a[j];
                    vt = j;
                }
            }
            b[i] = vt;
        }

        // in
        for (int i = n; i > 0; i--) {
            System.out.printf("%5.2f", a[b[i]]);
        }
    }

    //    Question 14:
//    Nhập một số tự nhiên n.
//    Hãy liệt kê các số Fibonaci nhỏ hơn n là số nguyên tố
    static void soFibonaciLaSoNguyenTo() {
        int n;
        System.out.println("Input: ");
        n = scanner.nextInt();
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 1;
        System.out.println("Output:");
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
            if (Exercise2.soNguyenTo(a[i]) == 1 && a[i] < n) System.out.printf("%5d", a[i]);
        }
    }

    //    Question 15:
//    Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng
//    sau:
//    a) Tính tổng các chữ số của n.
//    b) Phân tích n thành các thừa số nguyên tố.
    static void TongNSoVaThuaSoNguyenTo() {
        int n;
        System.out.println("Input:");
        n = scanner.nextInt();
        System.out.println("Output:");
        // tong cac chu so cua n;
        int tong = 0;
        String s = String.valueOf(n);
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            int number = Integer.parseInt(String.valueOf(s1[i]));
            tong = tong + number;
        }
        System.out.println(tong);

        // phan tich thanh thua so nguyen to
        for (int i = 2; i <= n; i++) {
            int dem = 0;
            while (n % i == 0) {
                dem++;
                n /= i;
            }
            if (dem != 0) {
                System.out.print(i);
                if (dem > 1) System.out.print("^" + dem);
                if (n > i) System.out.print("*");
            }
        }
    }

    /* Question 16:
Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau:
a) Liệt kê các ước số của n. Có bao nhiêu ước số.
b) Liệt kê các ước số là nguyên tố của n */
    static void TimUocvaSoNguyenTo() {
        int n;
        System.out.println("Input: ");
        n = scanner.nextInt();
        System.out.println("Output: ");
        // uoc cua 1 so
        List list = new LinkedList();
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0) {
                System.out.printf("%5d", i);
                if (soNguyenTo(i) == 1) list.add(i);
            }
        }
        System.out.println("");
        for (Object x : list) {
            System.out.printf("%5d", x);
        }
    }

//Question 17:
//        Viết chương trình liệt kê các số nguyên có 7 chữ số thoả mãn:
//        a) Là số nguyên tố.
//        b) Là số thuận nghịch.
//        c) Tổng các chữ số của số đó là một số thuận nghịch

    static void question17()
    {
        for (int i = 1000000; i < 10000000; i++)
        {
            if (soNguyenTo(i) == 1) {
                if (i == kiemtrasoThuanNghich(i))
                {
                    int tong = 0;
                        String s = String.valueOf(i);
                        char[] s1 = s.toCharArray();
                        for (int j = 0; j < s1.length; j++)
                        {
                            int number = Integer.parseInt(String.valueOf(s1[j]));
                            tong = tong + number;
                        }
                    if(tong==kiemtrasoThuanNghich(tong))
                    {
                        System.out.println(i);
                    }
                }
            }
        }
    }

//    Question 19:
//    Viết chương trình nhập vào vào mảng A có n phần tử, các phần tử là những số
//    nguyên lớn hơn 0 và nhỏ hơn 100 được nhập vào từ bàn phím.
//    Thực hiện các chức năng sau:
//    a) Tìm phần tử lớn nhất và lớn thứ 2 trong mảng cùng chỉ số của các số đó.
//            b) Sắp xếp mảng theo thứ tự giảm dần .
//    c) Nhập một số nguyên x và chèn x vào mảng A sao cho vẫn đảm bảo tính
//    sắp xếp giảm dần
    static void swap(int i, int j, int[] arr)
    {
        int tg=arr[i];
        arr[i]=arr[j];
        arr[j]=tg;
    }

        static void question19()
        {
            int n;
            System.out.println("Input:");
            n=scanner.nextInt();
            int a[] = new int[n];
            int vt1=-1,vt2=-1;
            int smax =0;
            // nhap va tim vi tri max 1 va max 2;
            for(int i=0;i<n;i++)
            {
                a[i]=scanner.nextInt();
                if(a[i]>smax) { smax = a[i]; vt1=i;}
            }
            System.out.printf("\n Max 1 la : %d va vi tri la : %d ",smax,vt1+1);
            smax=0;
            for(int i=0;i<n;i++)
            {
                if(a[i]>smax && i!=vt1)
                {
                    smax=a[i]; vt2=i;
                }
            }
            System.out.printf("\n Max 2 la : %d va vi tri la %d ",smax,vt2+1);
            // sap xep theo thu tu giam dan

            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(a[i]<a[j])
                    {
                        int tg=a[i];
                        a[i]=a[j];
                        a[j]=tg;
                    }
                }
            }
            // in
            for(int i=0;i<n;i++)
            {
                System.out.printf("%5d",a[i]);
            }
            // c
            int x;
            System.out.print("\n nhap so can chen : ");
            x = scanner.nextInt();
            a=Arrays.copyOf(a, a.length+1);
            a[a.length-1] = x;
            for(int i=a.length-1;i>0;i--)
            {
                if(a[i]>a[i-1])
                    swap(i,i-1,a);
            }
            System.out.println("Output sau khi chen them :");
            for(int i:a)
            {
                System.out.printf("%5d",i);
            }
        }
//        Question 20:
//    Viết chương trình thực hiện chuẩn hoá một xâu ký tự nhập từ bàn phím (loại bỏ
//các dấu cách thừa, chuyển ký tự đầu mỗi từ thành chữ hoa, các ký tự khác thành chữ thường)

    static void chuanhoaString()
    {
        String s;
        s=scanner.nextLine();
        s=s.toLowerCase();
        char[] ch = s.toCharArray();
        s="";
        if(Character.toString(ch[0])!=" ")
        {
            ch[0]=Character.toUpperCase(ch[0]);
            s=s+ch[0];
        }

        for(int i=1;i<ch.length;i++)
        {
            if(Character.toString(ch[i-1]).equals(" "))
            {
                ch[i]=Character.toUpperCase(ch[i]);
            }
            if(Character.toString(ch[i]).equals(" ")&& Character.toString(ch[i+1]).equals(" "))  i++;
             s=s+ch[i];
        }
        System.out.print("\n Output: " + s);
    }

//    Question 21:
//    Viết chương trình thực hiện nhập một xâu ký tự
//    a) Tìm từ dài nhất trong xâu đó.
//    b) Từ đó xuất hiện ở vị trí nào?
//    (Chú ý. nếu có nhiều từ có độ dài giống nhau thì chọn từ đầu tiên tìm thấy)
    static void question21(){
        String s;
        ArrayList list = new ArrayList<String>();
        s = scanner.nextLine();
        String s1; int dem=0;
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(Character.toString(ch[i]).equals(" ")) dem++;
        }
        do {
            s1="";
            for (int i = 0; i <ch.length; i++) {

                if (Character.toString(ch[i]).equals(" ")) {
                    list.add(s1);
                    s1 = "";
                    if (dem == list.size() - 1) break;
                }
                if (Character.toString(ch[i]).equals(" ")) i++;
                s1 = s1 + ch[i];
                if(i==ch.length-1)
                {
                    list.add(s1);
                    s1 = "";
                    if (dem == list.size() - 1) break;
                }

            }
        }while(dem!=list.size()-1);
        int maxc=0, vt=-1;
       for(int i=0;i< list.size();i++)
       {
           s1="";
           s1=s1+list.get(i);
          if(s1.length()>maxc) {
              maxc = s1.length();
              vt = i;
          }
       }
       System.out.print("\nOutput: "+list.get(vt)+ "\nco do vi tri "+(vt+1));
    }
}



