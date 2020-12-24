package emtity;

public class Question {
    private int questionid;
    private String content;
    int categoryid;  // dinh danh chu de cau hoi
    int typeid;    //dinh danh dang cau hoi
    int creatorid;  //dinh danh nguoi tao cau hoi
    private String createdate;  // gay/thang/nam tao cau hoi

    public Question(){

    }

    public Question(int questionid, String content, int categoryid, int typeid, int creatorid, String createdate) {
        this.questionid = questionid;
        this.content = content;
        this.categoryid = categoryid;
        this.typeid = typeid;
        this.creatorid = creatorid;
        this.createdate = createdate;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
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
