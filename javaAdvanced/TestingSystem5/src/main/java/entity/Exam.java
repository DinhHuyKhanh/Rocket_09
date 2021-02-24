package entity;

import backend.Repository.ExamRepository;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Exam" , catalog = "testingsystemabc")
public class Exam  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short examId;

    @Column(name="`Code`", length = 10)
    private String code;

    @Column(name="Title",length = 50, nullable = false)
    private String title;

    @Column(name="Duration",nullable = false, columnDefinition ="tinyint default 45")
    private short duration;

    @ManyToOne
    @JoinColumn(name="CategoryID",nullable = false)
    private TypeQuestion typeQuestion;

    @ManyToOne
    @JoinColumn(name="CreatorID",nullable = false)
    private Account creatorID;

    @Column(name ="CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Exam(){

    }
    @PrePersist
    public void beforeSavetoDatabase() {
        if(code == null){
            ExamRepository repository =  new ExamRepository();
            String prefix;
            if(duration >=180){
                prefix = "L";
            }else if( duration >=90){
                prefix = "M";
            }else{
                prefix = "S";
            }
            int count = repository.getCountOfExamCode(duration);
            code = prefix + "-"+ (count+1);
        }
    }

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
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

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public Account getCreatorID() {
        return creatorID;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", code='" + code + '\'' +
                ", title='" + title;
    }
}
