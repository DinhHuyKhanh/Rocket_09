package backend.exercise1;

import com.sun.javafx.collections.MappingChange;
import entity.Student;
import javafx.scene.web.WebHistory;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


public class question6 {
    Map<Integer,String> map = new HashMap<Integer, String>();
    Student student;
    Scanner scanner = new Scanner(System.in);
    public void nhap(){
        student = new Student();
        System.out.println("nhập id: ");
        student.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Nhập name: ");
        student.setName(scanner.nextLine());

        map.put(student.getId(), student.getName());

    }

    public void question6(){

        for(int i=0;i<3;i++)
        {
                nhap();
        }        System.out.println("Danh sach ");
        for(Integer key : map.keySet())
        {
            System.out.println("id: "+ key + "\nName: " +map.get(key));
        }
    }

    public void question7(){
//        Set<Map.Entry<Integer,String>> entries =  map.entrySet();
//        Comparator<Map.Entry<Integer,String>> comparator = new Comparator<Map.Entry<Integer, String>>() {
//            @Override
//            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        };
//
//        List<Map.Entry<Integer,String>> listentry = new ArrayList<>();
//        Collections.sort(listentry,comparator);
//
//        LinkedHashMap<Integer,String> sortMap = new LinkedHashMap<>(listentry.size());
//        for(Map.Entry<Integer,String> entry : listentry)
//        {
//            sortMap.put(entry.getKey(), entry.getValue());
//        }
//        System.out.println(" Danh sach map: ");
//        for(Map.Entry<Integer,String> x: listentry) {
//            System.out.println("Id: "+x.getKey() + "\nName: "+x.getValue());
//        }

        System.out.println("Danh sách học sinh sau khi sắp xếp! ");
        List<String> a = new ArrayList<>(map.values());
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String x: a)
        {
            System.out.println(x);
        }
    }

}
