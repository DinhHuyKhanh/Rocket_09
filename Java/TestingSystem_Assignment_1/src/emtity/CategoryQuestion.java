package emtity;

public class CategoryQuestion {
    private  int categoryid;
    private String categoryname; // ten chu de cau hoi



    public CategoryQuestion(){

    }

    public CategoryQuestion(int categoryid, String categoryname) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
