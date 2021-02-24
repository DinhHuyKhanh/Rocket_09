package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="`Manager`",catalog = "TestingSystemLesson5")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

//    @Column(name="AccountID")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private short accountID;

    @Column(name="ManagementNumberOfYear",nullable = false)
    private short managementNumberOfYear;

//    public short getAccountID() {
//        return accountID;
//    }
//
//    public void setAccountID(short accountID) {
//        this.accountID = accountID;
//    }

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void getManagementNumberOfYear(short managementNumberOfYear) {
        this.managementNumberOfYear = managementNumberOfYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", ManagementNumberOfYear=" + managementNumberOfYear +
                '}';
    }

}
