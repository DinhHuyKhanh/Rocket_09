package entity;

import entity.enumerate.SalaryName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Salary",catalog = "TestingSystemabc")
public class Salary implements Serializable {
    private static final  long serialVersionUID = 1L;

    @Column(name="SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name="SalaryName",nullable = false,unique = true)
    private SalaryName salaryName;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public SalaryName getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(SalaryName salaryName) {
        this.salaryName = salaryName;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salaryName=" + salaryName +
                '}';
    }
}
