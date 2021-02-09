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

    @Column(name="`Code1`", length = 10)
    private String code1;

    @Column(name="`Code2`", length = 10)
    private String code2;

    @Column(name="Title",length = 50, nullable = false)
    private String title;

    @Column(name="Duration",nullable = false, columnDefinition ="tinyint default 45")
    private short duration;

    @Column(name ="CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Exam(){

    }
    @PrePersist
    public void beforeSavetoDatabase() {
        if(code1 == null){
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
            code1 = prefix + "-"+ (count+1);
        }
    }

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
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

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", code1='" + code1 + '\'' +
                ", code2='" + code2 + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", createDate=" + createDate +
                '}';
    }



}
