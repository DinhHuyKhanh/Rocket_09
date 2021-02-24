package entity;


import entity.primaryKey.ExamQuestionKey;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ExamQuestion",catalog = "TestingSystemLesson5")
public class ExamQuestion  {

    @EmbeddedId
    private ExamQuestionKey id;

    @ManyToOne
    @MapsId("ExamID")
    @JoinColumn(name="ExamID")
    private Exam exam;

    @ManyToOne
    @MapsId("QuestionID")
    @JoinColumn(name = "QuestionID")
    private Question question;

    public ExamQuestionKey getId() {
        return id;
    }

    public void setId(ExamQuestionKey id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "id=" + id +
                ", exam=" + exam +
                ", question=" + question +
                '}';
    }
}
