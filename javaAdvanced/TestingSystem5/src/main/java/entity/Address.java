package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Address", catalog = "TestingSystemLesson5")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short addressId;

    @Column(name ="AddressName",length = 100, nullable = false, unique = true)
    private String addressName;

    @OneToOne(mappedBy = "address")
    private DetailDepartment department;

    public Address() {
    }

    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
