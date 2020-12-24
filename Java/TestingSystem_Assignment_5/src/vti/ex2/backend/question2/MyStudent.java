package vti.ex2.backend.question2;

import vti.ex2.entity.question2.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class MyStudent {
    Scanner scanner = new Scanner(System.in);
    Student student;
    ArrayList<Student> list = new ArrayList<Student>();

    public void InputInfo()
    {
        student = new Student();
        student.inputInfor();
        list.add(student);
    }
    public void showInfo(){
        for(Student x : list)
        {
            x.showInfo();
            x.xethocbong();
        }
    }
}
