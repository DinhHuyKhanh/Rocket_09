package backend.exercise2;

import entity.exercise2.Student;

import java.util.*;

public class sapxep {
    List<Student> list = new ArrayList<Student>();
    Student student;

public void nhap(){
    list.add(new Student(1,"Khanh","28-06-2001",10));
    list.add(new Student(2,"Trang","28-04-2001",8));
    list.add(new Student(3,"Lan","21-06-2001",7));
    list.add(new Student(4,"Huong","28-08-2001",10));
    list.add(new Student(5,"Hoai","11-06-2001",6));
    list.add(new Student(6,"Ngoc","28-2-2001",7));
    list.add(new Student(7,"Khanh","28-06-2001",9));
    list.add(new Student(8,"Trang","21-04-2001",8));
    list.add(new Student(9,"Lan","20-06-2001",7));
    list.add(new Student(10,"Huong","28-08-2001",9));
    list.add(new Student(11,"Hoai","15-06-2001",6));
    list.add(new Student(12,"Ngoc","1-1-2001",7));

}

public void sapxepname(){
    Collections.sort(list, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
    System.out.println("Danh sách sinh viên sap xep ten theo ampha");
    for(Student x: list)
    {
        x.in();
    }
}

// question2
    public void question2(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getName().equals(o2.getName()))
                    return o1.getDate().compareTo(o2.getDate());
                else if(o1.getName().equals(o2.getName()) && o1.getDate().equals(o2.getDate()))
                    return (int) (o1.getDiem() - o2.getDiem());
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Danh sach sinh vien question2 ");
        for(Student x: list)
        {
            System.out.println("--------------------------------");
            x.in();
            System.out.println("--------------------------------");
        }

    }

}
