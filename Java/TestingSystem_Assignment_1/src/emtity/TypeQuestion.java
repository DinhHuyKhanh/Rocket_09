package emtity;

public class TypeQuestion {
    private  int typeid;
    private  String typename;

    public TypeQuestion(){

    }

    public TypeQuestion(int typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}


