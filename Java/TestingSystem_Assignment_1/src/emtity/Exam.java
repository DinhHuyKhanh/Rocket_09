package emtity;

public class Exam {
    private int examid;
    private String code;
    private String title;
    int categoryid; //dinh danh chu de cau hoi;
    private int duration; // thoi gian thi
    int createid; // nguoi tao bai thi
    private String createdate; // ngay tao bai thi

    public Exam(){

    }

    public Exam(int examid, String code, String title, int categoryid, int duration, int createid, String createdate) {
        this.examid = examid;
        this.code = code;
        this.title = title;
        this.categoryid = categoryid;
        this.duration = duration;
        this.createid = createid;
        this.createdate = createdate;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCreateid() {
        return createid;
    }

    public void setCreateid(int createid) {
        this.createid = createid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
}
