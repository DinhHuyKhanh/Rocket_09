package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="`Question`",catalog = "TestingSystemLesson5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short questionID;

    @Column(name="Content", length = 50, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="CategoryID",nullable = false)
    private CategoryQuestion categoryQuestion;

    @ManyToOne
    @JoinColumn(name="TypeID",nullable = false)
    private TypeQuestion typeQuestion;

    @ManyToOne
    @JoinColumn(name="CreatorID",nullable = false)
    private Account account;

    @OneToMany(mappedBy = "question")
    private List<Answer>  answers;


    @Column(name="CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;



    public short getQuestionID() {
        return questionID;
    }

    public void setQuestionID(short questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", typeQuestion=" + typeQuestion +
                ", account=" + account +
                ", createDate=" + createDate +
                '}';
    }
}
