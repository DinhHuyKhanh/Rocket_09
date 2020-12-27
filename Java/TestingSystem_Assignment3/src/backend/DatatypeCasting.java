package backend;

import java.util.Random;
import java.util.Scanner;

public class DatatypeCasting {
    public void question1(){
        float account1=(float)5240.5;
        float account2=(float)  10970.055;
        System.out.println("account1 lam tron: "+ (int)account1);
        System.out.println("account2 lam tron: "+(int)account2);
    }
    public int ranBeetween(int start, int end){
        return start + (int)Math.round(Math.random()*(end-start));
    }
    public int question2(){
        Random random = new Random();
        int a = ranBeetween(1,99999);
        System.out.printf("so co 5 chu so la : %05d",a);
        return a;
    }
    public void question3()
    {
        int a=0;
        a=question2();
        String s;
        s= String.valueOf(a);
        char[] ch = s.toCharArray();
        System.out.println("2 so cuoi la :" +ch[ch.length-2]+ch[ch.length-1] );
    }
    public int question4(){
     int a;
     int b;
     Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap a: "); a = scanner.nextInt();
        System.out.println("Nhap b: "); b = scanner.nextInt();
        return a*b;
    }
    // exercise 2:
    public void question2_1(){
        // khoi tao 5 phan tu String;
        String[] a = new String[5];
        for(int i =0;i<5;i++)
        {
            a[i]="Email "+(i+1);
        }
        System.out.println(" sau khi khoi tao : ");
        for(int i=0;i<5;i++)
        {
            System.out.println(a[i]);
        }
    }



}
