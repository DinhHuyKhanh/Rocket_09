package backend;

import emtity.PrimaryStudent;
import emtity.SecondaryStudent;
import emtity.Student;

import java.util.ArrayList;

public class backendStudent {

    Student student;
    ArrayList<Student> list = new ArrayList<Student>();
    public void insert(){
        for(int i=0;i<3;i++) {
            student = new Student();
            student = new Student(1,"Nguyễn Văn "+i);
            list.add(student);
        }
    }

    public void showinf(){
        for(Student x: list)
        {
            System.out.println("==========================================");
            System.out.println("id: "+ x.getId());
            System.out.println("Name: "+x.getName());
            System.out.println("Trường: "+Student.getCollege());
            System.out.println("==========================================");
        }
    }

    public void dh(){
        Student.setCollege("Dai Hoc Cong Nghe");
    }

    public void question2(){
        System.out.println(" Tiền quỹ lớp ban đầu: "+ Student.getMoneyGroup());

        Student.setMoneyGroup(Student.getMoneyGroup()-50);
        System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: "+Student.getMoneyGroup() );

        Student.setMoneyGroup(Student.getMoneyGroup()-20);
        System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: "+Student.getMoneyGroup());

        Student.setMoneyGroup(Student.getMoneyGroup()-150);
        System.out.println(" Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: "+Student.getMoneyGroup());


        System.out.println("Nộp 50k tiền lần 2: ");

        for(int i=0;i<list.size();i++)
        {
            Student.setMoneyGroup(Student.getMoneyGroup()+50);
        }
        System.out.println("Tổng tiền quỹ lớp còn lại là: "+Student.getMoneyGroup());
    }

    public void question6(){
        PrimaryStudent primaryStudent;
        SecondaryStudent secondaryStudent;
        for(int i=0;i<6;i++)
        {
            if(question7()==false) break;
            else {
                if (i < 2) {
                    primaryStudent = new PrimaryStudent(i, "Nguyễn Văn primary" + i);
                    list.add(primaryStudent);
                } else {
                    secondaryStudent = new SecondaryStudent((i - 2), "Nguyễn Văn secon " + i);
                    list.add(secondaryStudent);
                }
            }
        }

        System.out.println("primary student is:  "+PrimaryStudent.getCount());
        System.out.println("secondary student is: "+SecondaryStudent.getCount());
        System.out.println("Student is: "+Student.getCount());
    }

    public boolean question7(){
        if(Student.getCount()<7) return true;
        return false;
    }


}
