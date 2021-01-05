package backend.exercise1;

import entity.Student;

import java.util.*;

public class question4 {
    // question4 và question5

    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<Student>();
    Set<String>  listname =  new HashSet<String>();


    public void nhap(){
        Student student = new Student();
        System.out.println("Mời bạn nhập id: ");
        student.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Mời bạn nhập name: ");
        student.setName(scanner.nextLine());

        students.add(student);
        listname.add(student.getName());
    }
    public void question4(){
            for(int i=0;i<4;i++)
            {
                nhap();
            }
        System.out.println("Danh sách sinh viên");
            for(Student x : students)
            {
                x.in();
            }

        System.out.println("Danh sách tên sinh viên");
        for(String x: listname)
        {
            System.out.println(x);
        }
        }

        public void question5(){

        ArrayList<String> list = new ArrayList<String>();
        list.addAll(listname);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

            System.out.println("danh sach");
        for(String x : list)
            System.out.println(x);

        }
}
