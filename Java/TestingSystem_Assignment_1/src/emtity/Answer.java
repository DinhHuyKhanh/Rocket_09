package emtity;

public class Answer {
    private int answerid;
    private String content;
    int questionid;
    private boolean isCorrect;

    public Answer(){

    }

    public Answer(int answerid, String content, int questionid, boolean isCorrect) {
        this.answerid = answerid;
        this.content = content;
        this.questionid = questionid;
        this.isCorrect = isCorrect;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
