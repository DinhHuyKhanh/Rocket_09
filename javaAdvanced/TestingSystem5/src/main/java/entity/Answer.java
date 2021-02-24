package entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer", catalog = "TestingSystemLesson5")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name ="Answers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short Answers;

    @Column(name="Content", length = 100, nullable = false)
    private String content;


    @ManyToOne
    @JoinColumn(name="QuestionID",nullable = false)
    private Question question;



    @Column(name = "isCorrect",columnDefinition = "BIT default 1")
    private boolean isCorrect ;

    public short getAnswers() {
        return Answers;
    }

    public void setAnswers(short answers) {
        Answers = answers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "Answers=" + Answers +
                ", content='" + content + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
