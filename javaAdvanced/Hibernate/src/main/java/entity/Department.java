package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Department",catalog = "TestingSystemabc")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short departmentId;

    @Column(name="DepartmentName",length = 30, nullable = false, unique = true)
    private String departmentName;

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
