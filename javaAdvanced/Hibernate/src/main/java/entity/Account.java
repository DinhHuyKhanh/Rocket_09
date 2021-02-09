package entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="`Account`",catalog = "TestingSystemabc")
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


    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
