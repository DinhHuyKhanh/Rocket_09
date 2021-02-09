package entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer", catalog = "testingsystemabc")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name ="Answers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short Answers;

    @Column(name="Content", length = 100, nullable = false)
    private String content;

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

    @Override
    public String toString() {
        return "Answer{" +
                "Answers=" + Answers +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
