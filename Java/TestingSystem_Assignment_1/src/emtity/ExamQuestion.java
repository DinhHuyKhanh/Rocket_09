package emtity;


public class ExamQuestion {
    int examid;
    int questionid;

    public ExamQuestion() {

    }

    public ExamQuestion(int examid, int questionid) {
        this.examid = examid;
        this.questionid = questionid;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }
}
