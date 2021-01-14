package entity;


/**
 * @Description
 * @author: Đinh Huy Khánh
 * @creat_date: 13-1-2021
 * @modifer:
 * @modifer_date:
 * */

public class Manager extends User {
    private int expInYear;
    private  int userid;

    public Manager(int userid,int expInYear) {
        super();
        this.userid = userid;
        this.expInYear = expInYear;
    }

    public Manager(int id, String name, String email, String password, int expInYear) {
        super(id, name, email, password);
        this.expInYear = expInYear;
        this.userid = userid;
    }

    public Manager(){
        super();
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public static void tieuDe(){
        System.out.printf("|%-5s|%-30s|%-30s|%-20s|%-5s|%n","id","Full Name","Email","password","Exp");
        System.out.println("------------------------------------------------------------------------------------------------");

    }
    public void inThongTin(){
        System.out.printf("|%-5d|%-30s|%-30s|%-20s|%-5d|%n",super.getId(),super.getName(),super.getEmail(),super.getPassword(),getExpInYear());
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
