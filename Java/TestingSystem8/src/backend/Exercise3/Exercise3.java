package backend.Exercise3;

import entity.Exercise3.Student;

import java.util.ArrayList;

public class Exercise3<T> {


    public Exercise3(){

    }
    public void question1(){
       Student student = new Student(1, " Ob1");
       Student student1 = new Student((float)2.0,"ob2");
       Student student2 = new Student((double)3.0,"ob3");
    }
    public void nhap( T object )  {
        System.out.println("Ket qua: " + object);
    }
}
