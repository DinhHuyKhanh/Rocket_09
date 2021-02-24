package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Department",catalog = "TestingSystemLesson5")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short departmentID;

    @Column(name="DepartmentName",length = 30, nullable = false, unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Account> accounts;


    public short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(short departmentId) {
        this.departmentID = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", accounts=" + accounts+
                '}';
    }
}
