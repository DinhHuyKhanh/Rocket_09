package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Group", catalog = "TestingSystemLesson5")
public class group implements Serializable {

    private static final  long serialVersionUID = 1L;

    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short groupId;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @ManyToOne
    @JoinColumn(name="CreatorID",nullable = false)
    private Account creator;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


    public short getGroupId() {
        return groupId;
    }

    public void setGroupId(short groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator.getFullName() +
                ", createDate=" + createDate +
                '}';
    }
}
