package backend.exercise1.question1;

import entity.Student;

import java.util.*;


public class Studentchucnang {
    Scanner scanner = new Scanner(System.in);
    Student student ;
    ArrayList<Student> list = new ArrayList<Student>();
        public void insert(){
            for(int i=0;i<10;i++){
              list.add(new Student("Nguyễn Văn "+i));
            }
        }
        public void showinf(){
            for (Student x :list) {
                x.in();
            }
        }

        public void layphantuthu4(){
            System.out.println("Học sinh thứ 4 trong danh sách: ");
            list.get(3).in();
        }

        public void firstAndLast(){
            System.out.println("Học sinh đầu và học sinh cuối");
            System.out.println("Học sinh đầu: ");
            list.get(0).in();
            System.out.println("Học sinh cuối: ");
            list.get(list.size()-1).in();
        }

        public void addFirstStudent(){
            list.add(0,new Student("Nguyễn Văn  " +(Student.getCount()+1)));
        }
        public void addLastStudent(){
            list.add(list.size()-1,new Student("Nguyễn Văn "+(Student.getCount()+1)));
        }

        public void daonguoc(){
            for(int i=list.size()-1; i>=0;i--)
            {
                list.get(i).in();
            }
        }
        public int searchId(int start, int second, int id){

            if(second >=1) {
                int mid = start + (second - start) / 2;

                if (list.get(mid).getId() == id)
                    return mid;
                if(list.get(mid).getId() > id)
                    return searchId(start,mid-1,id);
                else if(list.get(mid).getId() < id)
                    return searchId(mid+1,second,id);
            }
            return -1;
        }

        public void timkiem(){
            int idnew;
            System.out.println("Mời bạn nhập id muốn tìm: ");
            idnew = scanner.nextInt();
            int vt = searchId(0,list.size()-1, idnew);

            if(vt ==-1) System.out.println("Không tìm thấy học sinh có id là: "+idnew);
            else
            {
                System.out.println("Kết quả bạn muốn tìm: ");
                list.get(vt).in();
            }
        }

        public void searchName(){
            String name;
            System.out.println("Nhập họ và tên người muốn tìm: ");
            name = scanner.nextLine();
            scanner.close();
            System.out.println("Kết quả bạn muốn tìm :");
            for (int i=0;i<list.size();i++)
            {
                if(list.get(i).getName().equals(name)) {
                    list.get(i).in();
                    break;
                }
            }
        }
        //i Tạo 1 method để in ra các student có trùng tên\
    public String  tachten(String name){
            String namenew ="";
            char[] ch = name.toCharArray();
            for(int i=ch.length-1 ;i>=0;i--)
            {
                if(Character.toString(ch[i]).equals(" "))
                    break;

                namenew = namenew + ch[i];

            }
            return namenew;
    }
    public void trungten(){
            String newname;
            Set<Student> set = new HashSet<Student>();
        for(int i=0;i<list.size()-1;i++)
            for(int j=list.size()-1;j>i;j--)
            {
                String name1,name2;
                name1= tachten(list.get(i).getName());
                name2 = tachten(list.get(j).getName());
                if(name1.equals(name2))
                {
                    set.add(list.get(i));
                    set.add(list.get(j));
                }
            }
        for(Student x : set)
        {
            x.in();
        }
    }
    public void xoaten(){
        System.out.println("Nhập id người bạn muốn xóa tên : ");
        int id = scanner.nextInt();
        int vt = searchId(0,list.size()-1,id);
        list.get(vt).setName(" ");

        System.out.println(" xóa tên thành công");
    }
    public void deleteid(){
        System.out.println("Mời bạn nhập id người muốn xóa : ");
        int id = scanner.nextInt();
        int vt = searchId(0,list.size()-1,id);
        list.remove(vt);
        System.out.println("Đã xóa thành công. ");
    }

    public void saoChepArrraylist(){
            ArrayList<Student> studentCopies = (ArrayList<Student>) list.clone();
    }







}
