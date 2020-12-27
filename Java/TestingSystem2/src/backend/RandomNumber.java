package backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.text.ParseException;
import  java.util.GregorianCalendar;

public class RandomNumber {
        Random random = new Random();
        public void question1(){
            int a = random.nextInt();
            System.out.println(a);
        }
        public void question2(){
            float a=random.nextFloat();
            System.out.println(a);
        }
        public void question3(){
            String[] a = new String[4];
            a[0] =" Khánh";
            a[1]=  "Hoài";
            a[2] = "Hương";
            a[3] = "Lan";
            System.out.println(a[random.nextInt(4)]);
        }
        public void question4() throws  ParseException{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            int month = ranBeetween(7,12);
            int dd = ranBeetween(1,30);
            String s = dd + "-"+month+"-"+"1995";
            Date date3 = simpleDateFormat.parse(s);
            System.out.println(simpleDateFormat.format(date3));
        }
        public int ranBeetween(int start, int end){
            return start + (int)Math.round(Math.random()*(end-start));
        }

        public void question5() throws ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
            int year = ranBeetween(2010,2020);
            int month = ranBeetween(1,12);
            int dd;
            if(month==1 || month ==3 || month ==5 || month==7 || month ==8 || month ==10 || month==12)
                dd = ranBeetween(1,31);
            else
            {
                if(month==2 && year%4==0) {
                    dd= ranBeetween(1,29);
                }else{
                    if(month==2) dd= ranBeetween(1,28);
                    else
                    dd = ranBeetween(1,30);
                }
            }
            String s= year+"-"+month+"-"+dd;
            Date date = simpleDateFormat.parse(s);
            System.out.println("Date: "+simpleDateFormat.format(date));
        }

    public void question6() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        int year = ranBeetween(1,2020);
        int month = ranBeetween(1,12);
        int dd;
        if(month==1 || month ==3 || month ==5 || month==7 || month ==8 || month ==10 || month==12)
            dd = ranBeetween(1,31);
        else
        {
            if(month==2 && year%4==0) {
                dd= ranBeetween(1,29);
            }else{
                if(month==2) dd= ranBeetween(1,28);
                else
                    dd = ranBeetween(1,30);
            }
        }
        String s= year+"-"+month+"-"+dd;
        Date date = simpleDateFormat.parse(s);
        System.out.println("Date: "+simpleDateFormat.format(date));
    }
    public void question7(){
            int a = ranBeetween(100,999);
        System.out.println("so co 3 chu so : "+a);
    }

}
