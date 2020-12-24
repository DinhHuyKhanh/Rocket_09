package emtity;

public class Account {
    private     int accountid;
    private     String email;
    private     String username;
    private     String fullname;
    private     int  departmentid;
    private     int    positionid;
    private     String  date;

    public Account(){

    }

    public Account(int accountid, String email, String username, String fullname, int departmentid, int positionid, String date) {
        this.accountid = accountid;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.departmentid = departmentid;
        this.positionid = positionid;
        this.date = date;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getPositionid() {
        return positionid;
    }

    public void setPositionid(int positionid) {
        this.positionid = positionid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

