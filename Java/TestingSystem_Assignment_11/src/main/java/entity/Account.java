package entity;

public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;
    private int DepartmentId;
    private int positionID;
    private String CreateDate;

    public Account(int accountId, String email, String userName, String fullName, int departmentId, int positionID, String createDate) {
        this.accountId = accountId;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        DepartmentId = departmentId;
        this.positionID = positionID;
        CreateDate = createDate;
    }

    public Account(){}

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartment() {
        return DepartmentId;
    }

    public void setDepartment(int department) {
        DepartmentId = department;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public void print(){
        System.out.printf("%-10s | %-30s | %-20s | %-20s %-20s %-20s %-20s %n","Account ID","Email","User Name","Full Name","Department ID","Position ID","Create Date");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void printf(){
       // System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10d | %-30s | %-20s | %-20s | %-20d | %-20d | %-20s %n",accountId,email,userName,fullName,DepartmentId,positionID,CreateDate);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

    }



}
