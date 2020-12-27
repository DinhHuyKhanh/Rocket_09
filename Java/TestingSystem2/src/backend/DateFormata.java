package backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormata {

    public void question1() throws ParseException {
        // Khác project nên tôi sẽ tạo 1 string date và chuyển về dạng date;
        String s= "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(s);
        Date date = simpleDateFormat.parse("10-12-2020");

        System.out.println("Date: "+simpleDateFormat.format(date));
        System.out.println("Date E: " +date);
    }
    public void question2() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String s = "2020-12-10 18:20:40";
        Date date = simpleDateFormat.parse(s);
        System.out.println(simpleDateFormat.format(date));
    }
    public void question3() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
        String s = "2020-12-10 18:20:40";
        Date date = simpleDateFormat.parse(s);
        System.out.println(simpleDateFormat.format(date));
    }
    public void question4() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM");
        String s = "2020-12-10 18:20:40";
        Date date = simpleDateFormat.parse(s);
        System.out.println(simpleDateFormat.format(date));
    }
    public void question5() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "2020-12-10 18:20:40";
        Date date = simpleDateFormat.parse(s);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM-dd");
        System.out.println(simpleDateFormat1.format(date));
    }
}
