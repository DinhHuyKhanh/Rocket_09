package vti.ex2.backend.question1;

import vti.ex2.entity.question1.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class mystudent {
    Student  student ;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> list = new ArrayList<Student>();

    public void nhap(){
        student = new Student();

        System.out.println("Mời bạn nhập id: ");
        student.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Mời bạn nhập Họ và tên: ");
        student.setName(scanner.nextLine());

        System.out.println("Mời bạn nhập group:" );
        student.setGroup(scanner.nextInt());

        list.add(student);
    }

    public void nhap10hocsinh()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Học sinh "+(i+1));
            nhap();
        }
    }
    public void diemdanh(){
        for(Student x: list)
        {
            x.diemdanh();
        }
    }
    public void hocbai(){
        for(Student x: list)
        {
            x.hocbai();
        }
    }
    public void donvesinh(){
        for(Student x: list)
        {
            x.vesinh();
        }
    }




}
