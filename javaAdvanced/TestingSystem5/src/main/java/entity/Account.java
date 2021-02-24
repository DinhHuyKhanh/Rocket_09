package entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="`Account`",catalog = "TestingSystemLesson5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short accountID;

    @Column(name="Email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name="Username", length = 50, nullable = false, unique = true)
    private String userName;

    @Column(name="FirstName", length = 50, nullable = false)
    private String firstName;

    @Column(name="LastName", length = 50, nullable = false)
    private String lastName;


    @Formula(" concat(FirstName,' ',LastName) ")
    private String fullName;

    //TO DO default now
    @Column(name="CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


    @ManyToOne
    @JoinColumn(name="DepartmentID",nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name="PositionID", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name="SalaryID", nullable = false)
    private  Salary salary;

    @OneToMany(mappedBy = "creator")
    private List<group> CreatorGroup;

    @OneToMany(mappedBy = "account")
    private List<Question> questions;

    @OneToMany(mappedBy = "creatorID")
    private List<Exam> exams;


    public List<group> getCreatorGroup() {
        return CreatorGroup;
    }

    public void setCreatorGroup(List<group> creatorGroup) {
        CreatorGroup = creatorGroup;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public short getAccountID() {
        return accountID;
    }

    public void setAccountID(short accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName;
    }
}
