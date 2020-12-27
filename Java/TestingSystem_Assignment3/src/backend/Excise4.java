package backend;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Excise4 {
    public Scanner scanner = new Scanner(System.in);
    public void question1(){
        String s;
        System.out.println("Nhap xau ki tu: "); s = scanner.nextLine();
        char[] ch = s.toCharArray();
        int dem=0;
        for(int i=0;i<ch.length;i++)
        {
            if(Character.toString(ch[i]).equals(" ")) dem++;
        }
        System.out.println("So ki tu la: "+(s.length()-dem));
    }
    public void question2(){
        String s1,s2;
        System.out.println("Nhap xau ki tu s1: "); s1=scanner.nextLine();
        //scanner.nextInt();
        System.out.println("Nhap sau ki tu s2:"); s2=scanner.nextLine();
        scanner.close();
        s1=s1+s2;
        System.out.println("Sau khi noi xau: "+s1);
    }
    public void question3(){
        String name;
        System.out.println("Nhap name: ");
        name = scanner.nextLine();

        char[] ch = name.toCharArray();
        name = Character.toString(ch[0]).toUpperCase();
        for(int i=1;i<ch.length;i++)
        {
            name=name+ch[i];
        }
        System.out.println("Name: "+name);
    }
    public void question4(){
        String name;

        System.out.println(" Nhap name: ");
        name = scanner.nextLine();

        char[] ch = name.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            char a;
            a = Character.toUpperCase(ch[i]);
            System.out.println("Ký tự thứ "+(i+1)+" là: "+a);
        }
    }
    public void question5(){
        String lastname,firstname;
        System.out.println("Nhập họ của bạn: "); firstname = scanner.nextLine();
        System.out.println("Nhập tên của bạn: "); lastname = scanner.nextLine();

        String fullname = firstname +" "+ lastname;
        System.out.println("Full name: "+fullname);
    }
    public void question6(){
        String fullname;
        System.out.println("Nhap full name: ");
        fullname = scanner.nextLine();

        char[] ch = fullname.toCharArray();
        String s ="";
        for(int i=0;i<ch.length;i++)
        {
            s=s+ch[i];
            if(Character.toString(ch[i]).equals(" ")|| (i+1)==ch.length)
            {
                System.out.println(s);
                s="";
                continue;
            }
        }
    }
    public void question7_a(){

        String s;
        System.out.println("Mời bạn nhập full name: ");
        s=scanner.nextLine();
        s=s.toLowerCase();
        char[] ch = s.toCharArray();
        s="";
        if(Character.toString(ch[0]).equals(" ")==false) {
            s=s+ch[0];
        }
        for(int i=1;i<ch.length;i++)
        {
            if(Character.toString(ch[i]).equals(" ") && Character.toString(ch[i-1]).equals(" "))  continue;
            s=s+ch[i];
        }
        System.out.println("Output:"+s);

    }

    public void question7_b(){

            String s;
        System.out.println("Moi ban nhap full name: ");
            s=scanner.nextLine();
            s=s.toLowerCase();
            char[] ch = s.toCharArray();
            s="";
            if(Character.toString(ch[0]).equals(" ")==false)
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
                if(Character.toString(ch[i]).equals(" ") && Character.toString(ch[i-1]).equals(" "))  continue;
                s=s+ch[i];
            }
            System.out.println("Output:" + s);
        }

        public void question8(){
        // su dung equals de so sanh kieu du lieu String tuong tu nhu tren.
        }
        public void question9(){
        // tuong tu question8;
        }
        public String daonguoc(String s)
        {
            char[] ch = s.toCharArray();
            s="";
            for(int i=ch.length-1;i>=0;i--)
            {
                s=s+ch[i];
            }
            return  s;
        }
        public void question10(){
        String s1,s2;
            System.out.println("Nhập s1: ");
            s1 = scanner.nextLine();
            System.out.println("Nhập s2: ");
            s2 = scanner.nextLine();

            if(s1.equals(daonguoc(s2))) System.out.println("OK");
            else System.out.println("KO");
        }


        public void question11(){
        String s;
            System.out.println("Nhập s: ");
            s = scanner.nextLine();

            char[] ch= s.toCharArray();
            int res=0;
            for(int i=0;i<ch.length;i++)
            {
                if(Character.toString(ch[i]).equals("a")) res++;
            }
            System.out.println("Số lần xuất hiện ký tự a là: "+res);
        }

        public void question12(){
            String s;
            System.out.println("Nhập s: ");
            s = scanner.nextLine();
            System.out.println("Sau khi đảo ngược: "+ daonguoc(s));
        }
        public boolean kiemtraso(String s){
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]>=48 && ch[i]<=57)
                return false;
        }
        return true;
        }

        public void question13(){
        String s;
            System.out.println("Nhập s: ");
            s = scanner.nextLine();

            System.out.println("Output: "+s+ " là: "+kiemtraso(s) );
        }

        public void question14(){
        String s;
            System.out.println("Nhập s: ");
            s=scanner.nextLine();

            char[] ch = s.toCharArray();
            s="";
            for(int i=0;i<ch.length;i++)
            {
                if(Character.toString(ch[i]).equals("e")) s=s+"*";
                else s=s+ch[i];
            }
            System.out.println("Output sau khi chuyển e thành * là: "+s);
        }
        public void question15(){
        String s;
            System.out.println("Nhập s: ");
            s=scanner.nextLine();
            s= xoadaucach(s);
            s= tach_tu_va_dao_nguoc(s);
            System.out.println(s);
        }
    public String  xoadaucach(String s){
        char[] ch = s.toCharArray();
        s="";
        if(Character.toString(ch[0]).equals(" ")==false) {
            s=s+ch[0];
        }
        for(int i=1;i<ch.length;i++)
        {
            if(Character.toString(ch[i]).equals(" ") && Character.toString(ch[i-1]).equals(" "))  continue;
            s=s+ch[i];
        }
        return s;
    }

    public String tach_tu_va_dao_nguoc(String s){
        char[] ch = s.toCharArray();
        String s1="";
        String s2="";
        for(int i=ch.length-1;i>=0;i--)
        {
            s1=s1+ch[i];

            if(Character.toString(ch[i]).equals(" ")|| i==0)
            {
                s2 = s2+ daonguoc(s1);
                s1=" ";
            }
        }
        return s2;
    }
    public void question16(){
        String s;
        int n=0;
        System.out.println("Nhập s: ");
        s = scanner.nextLine();
        System.out.println("Nhập n: ");
        n = scanner.nextInt();

        if(s.length()%n!=0) System.out.println("KO");
        else
        {
            char [] ch = s.toCharArray();
            s="";
            for(int i=0;i<ch.length;i++)
            {
                s=s+ch[i];
                if((i+1)%n==0)
                {
                    System.out.println(s);
                    s="";
                }
            }
        }
    }
}

