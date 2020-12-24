package emtity;

public class Group {
        private  int groupid; // id group
        private String groupname; // ten group
        int creatorid; // id nguoi tao
        private String createdate; // ngay tap group

    public Group() {
    }

    public Group(int groupid, String groupname, int creatorid, String createdate) {
        this.groupid = groupid;
        this.groupname = groupname;
        this.creatorid = creatorid;
        this.createdate = createdate;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

}
