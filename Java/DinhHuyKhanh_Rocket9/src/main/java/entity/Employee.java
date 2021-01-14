package entity;
/**
 * @Description
 * @author: Đinh Huy Khánh
 * @creat_date: 13-1-2021
 * @modifer:
 * @modifer_date:
 * */
public class Employee extends User{
    private int projectid;
    private String proSkill;
    private int userid;

    public Employee(int id, String name, String email, String password, int projectid, String proSkill) {
        super(id, name, email, password);
        this.projectid = projectid;
        this.proSkill = proSkill;
    }

    public Employee(){
        super();
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public static void tieuDe(){
        System.out.printf("|%-5s|%-30s|%-30s|%-20s|%-15s|%-20s|%n","id","Full Name","Email","password","projectID","ProSkill");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

    }
    public void inThongTin(){
        System.out.printf("|%-5d|%-30s|%-30s|%-20s|%-15d|%-20s|%n",super.getId(),super.getName(),super.getEmail(),super.getPassword(),getProjectid(),getProSkill());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }
}
