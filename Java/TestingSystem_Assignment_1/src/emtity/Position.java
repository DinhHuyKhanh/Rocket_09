package emtity;

public class Position {
    private     int positionid;
    private String positionname;
    public Position(){

    }

    public Position(int positionid, String positionname) {
        this.positionid = positionid;
        this.positionname = positionname;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public Position(int positionid) {
        this.positionid = positionid;
    }

    public int getPositionid() {
        return positionid;
    }

    public void setPositionid(int positionid) {
        this.positionid = positionid;
    }

}

