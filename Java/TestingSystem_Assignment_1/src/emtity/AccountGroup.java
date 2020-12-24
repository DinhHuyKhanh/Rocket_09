package emtity;

import java.util.ArrayList;

public class AccountGroup {
    int   groupid;
    int accountid;
    private String joindate; // ngay user tham gia vao nhom

    public AccountGroup(){

    }

    public AccountGroup(int groupid, int accountid, String joindate) {
        this.groupid = groupid;
        this.accountid = accountid;
        this.joindate = joindate;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }
}

