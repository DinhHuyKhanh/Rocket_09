package vti.ex2.entity.question1;

public class Student implements  IStudent{
    private int id;
    private  String name;
    private  int group;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void diemdanh() {
            System.out.println(getName() + " điểm danh");
    }

    @Override
    public void vesinh() {
        if(this.group==2)
            System.out.println(getName() + " đang dọn vệ sinh");
    }

    @Override
    public void hocbai() {
        if(this.group==1)
            System.out.println(getName() + " đang học bài");
    }



}
