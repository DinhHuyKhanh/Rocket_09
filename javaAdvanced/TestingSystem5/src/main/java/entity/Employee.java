package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="`Employee`", catalog = "TestingSystemLesson5")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends  Account implements Serializable {
    private static final long serialVersionUID  = 1L;

//    @Column(name="AccountID")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private short accountID;

    @Column(name="WorkingNumberOfYear",nullable = false)
    private short workingNumberOfYear;



    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workingNumberOfYear=" + workingNumberOfYear +
                '}';
    }
}
