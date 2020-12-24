package backend;

import  emtity.*;


public class show {
    public void department(){
        Department a = new Department();
        System.out.println("ID: "+a.getDepartmentid());
        System.out.println("Name: "+a.getDepartmentname());
    }
    public void position(){
        Position a = new Position();
        System.out.println("id: "+a.getPositionid());
        System.out.println("Name: "+ a.getPositionname());
    }
    public void account(){
        Account a = new Account();
        System.out.println("id: "+ a.getAccountid());
        System.out.println("Email: " + a.getEmail());
        System.out.println("User name: "+a.getUsername());
        System.out.println("FUll name: " + a.getFullname());
        System.out.println("Department ID: "+a.getDepartmentid());
        System.out.println("Postion id: "+ a.getPositionid());
        System.out.println("Date: "+a.getDate());
    }
    public void group(){
        Group a = new Group();
        System.out.println("ID: "+ a.getGroupid());
        System.out.println("Name: "+a.getGroupname());
        System.out.println("Category id: "+a.getCreatorid());
        System.out.println("Date: "+a.getCreatedate());
    }
    public void groupaccount(){
        AccountGroup a = new AccountGroup();
        System.out.println("account id: "+a.getAccountid());
        System.out.println("group id: "+a.getGroupid());
        System.out.println("join date: "+a.getJoindate());
    }
}
