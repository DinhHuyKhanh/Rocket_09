package backend;

import emtity.*;

public class insertAndShow {
    public void department(Department[] departments){
        departments = new Department[3];
        departments[0] = new Department(1,"sale");
        departments[1] = new Department(2,"marketing");
        departments[2] = new Department(3,"manages");
        for(int i=0;i<3;i++)
        {
            showdepartment(departments[i]);
        }
    }
    public void showdepartment(Department a){
        System.out.println("Department ----------\n ");
        System.out.println("ID: "+a.getDepartmentid());
        System.out.println("Name: "+a.getDepartmentname());
        System.out.println("Department ----------\n ");
    }
    public void position(Position[] positions){
        positions = new Position[5];
        positions[0] = new Position(1,"Dev");
        positions[1] = new Position(2,"Test");
        positions[2] = new Position(3,"Scrum");
        positions[3] = new Position(4,"Master");
        positions[4] = new Position(5,"PM");

        for(int i=0;i<5;i++)
        {
            showposition(positions[i]);
        }
    }
    public void showposition(Position a){
        System.out.println("position ----------\n ");
        System.out.println("id: "+a.getPositionid());
        System.out.println("Name: "+ a.getPositionname());
        System.out.println("position ----------\n ");
    }
    public void accoun(Account[] accounts){
        accounts = new Account[3];
        accounts[0] = new Account(1,	"khanhdinh141@gmail.com",	"dinhkhanh141"	 ,"Đinh Huy Khánh",	1,	1,	"2020-11-27");
        accounts[1] = new Account(2,	"anloc145@gmail.com",	"anloc145",	 "Nguyễn An Lộc",	2,	1,	"2020-11-27");
        accounts[2] = new Account(3,	"nguyenthu151@gmail.com",	"nguyenthu151",	 "Nguyễn Thị Thu",	3,	2,	"2020-11-27");

        for(int i=0;i<3;i++)
        {
                showaccount(accounts[i]);
        }
    }
    public void showaccount(Account a){
        System.out.println("account------------------------------------------------------\n");
        System.out.println("id: "+ a.getAccountid());
        System.out.println("Email: " + a.getEmail());
        System.out.println("User name: "+a.getUsername());
        System.out.println("FUll name: " + a.getFullname());
        System.out.println("Department ID: "+a.getDepartmentid());
        System.out.println("Postion id: "+ a.getPositionid());
        System.out.println("Date: "+a.getDate());
        System.out.println("account------------------------------------------------------\n");

    }
    public void group(Group[] group){
        group = new Group[3];
        group[0] = new Group(1,	"404 Not Found",	2,	"2019-01-01");
        group[1] = new Group(2,	"CLB người cao tuổi"	,1,	"2019-01-01");
        group[2] = new Group(3,	"Viện tâm thần",	3,	"2019-01-01");

        for(int i=0;i<3;i++)
        {
            showgroup(group[i]);
        }
    }
    public void showgroup(Group a){
        System.out.println("Group --------------------------------\n");
        System.out.println("ID: "+ a.getGroupid());
        System.out.println("Name: "+a.getGroupname());
        System.out.println("Category id: "+a.getCreatorid());
        System.out.println("Date: "+a.getCreatedate());
        System.out.println("Group--------------------------------\n");
    }
    public void groupaccount(AccountGroup[] ac){
        ac = new AccountGroup[3];
        ac[0] = new AccountGroup(1,1,"2020-01-01");
        ac[1] = new AccountGroup(2,2,"2020-01-02");
        ac[2] = new AccountGroup(1,3,"2020=01-01");

        for(int i=0;i<3;i++)
        {
            showgroupaccount(ac[i]);
        }
    }
    public void showgroupaccount(AccountGroup a){
        System.out.println("AccountGroup------------------------------------------");
        System.out.println("account id: "+a.getAccountid());
        System.out.println("group id: "+a.getGroupid());
        System.out.println("join date: "+a.getJoindate());
        System.out.println("AccountGroup------------------------------------------");
    }
    public void typequestion(){
        System.out.println(" Insert tương tự");
    }
    public void categoryquestion(){
        System.out.println(" Insert tương tự");
    }
    public void question(){
        System.out.println(" Insert tương tự");
    }
    public void answer(){
        System.out.println(" Insert tương tự");
    }
    public  void exam(){
        System.out.println(" Insert tương tự");
    }
    public void examquestion(){
        System.out.println(" Insert tương tự");
    }

}
