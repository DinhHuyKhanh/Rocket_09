package entity;

import entity.enumerate.SalaryName;
import entity.enumerate.SalaryNameConvert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="`Salary`",catalog = "TestingSystemLesson5")
public class Salary implements Serializable {
    private static final  long serialVersionUID = 1L;

    @Column(name="SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name="SalaryName",nullable = false,unique = true)
    @Convert(converter = SalaryNameConvert.class)
    private SalaryName salaryName;

    @OneToMany(mappedBy = "salary",cascade = CascadeType.ALL)
    private List<Account> accounts;

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
        return "SalaryRepository{" +
                "id=" + id +
                ", salaryName=" + salaryName +
                '}';
    }
}
