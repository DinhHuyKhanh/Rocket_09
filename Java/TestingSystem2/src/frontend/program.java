package frontend;

import backend.DateFormata;
import backend.InputFromConsole;
import backend.RandomNumber;
import backend.SystemOutPrintf;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

public class program {
    public static void main(String[] args) throws ParseException {
        SystemOutPrintf a = new SystemOutPrintf();
        DateFormata b = new DateFormata();
       // b.question1();
//        b.question2();
        //b.question3();
//        b.question4();
//        b.question5();
        RandomNumber c = new RandomNumber();
        c.question1();
        c.question2();
        c.question3();
        c.question4();
        c.question5();
        c.question6();
        c.question7();
        InputFromConsole d = new InputFromConsole();
        d.question4();
    }
}
