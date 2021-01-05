package backend.exercise1.question3;

import entity.Student;

import java.util.*;

public class Seto {
    Set<Student> studentSet = new LinkedHashSet<Student>();
    Student student ;

    public void insert(){
        for(int i=0;i<10;i++){
            studentSet.add(new Student("Nguyễn Văn "+i));
        }
    }
    public void showinf(){
        for (Student x :studentSet) {
            x.in();
        }
    }

    public void layphantuthu4(){
        System.out.println("Học sinh thứ 4 trong danh sách: ");
        Iterator<Student> iterator = studentSet.iterator();
        Student student;
        while(iterator.hasNext()) {
            student = iterator.next();
            if (student.getId() == 4) {
                student.in();
                break;
            }
        }
    }


    public void firstAndLast(){
        System.out.println("Học sinh đầu và học sinh cuối");
        Iterator<Student> iterator = studentSet.iterator();
        Student student;
        student = iterator.next();
        System.out.println("Học sinh đầu: ");
        student.in();
        System.out.println("Học sinh cuối: ");
        while(iterator.hasNext())
        {
            student = iterator.next();
            if(iterator.hasNext() == false)
                student.in();
        }
    }

    public void searchId(int id){
        Student student;
        Iterator<Student> iterator = studentSet.iterator();
       while(iterator.hasNext())
       {
           student = iterator.next();
           if(student.getId()==id)
           {
               student.in();
               break;
           }
       }
    }

    public void timkiem(){
        int idnew;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập id muốn tìm: ");
        idnew = scanner.nextInt();

        searchId(idnew);
    }

    public void searchName(){
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ và tên người muốn tìm: ");
        name = scanner.nextLine();
        scanner.close();

        System.out.println("Kết quả bạn muốn tìm :");

        Iterator<Student> iterator = studentSet.iterator();
        Student student;

        while(iterator.hasNext())
        {
            student = iterator.next();
            if(student.getName().equals(name))
            {
                student.in();
                break;
            }
        }
    }

}
