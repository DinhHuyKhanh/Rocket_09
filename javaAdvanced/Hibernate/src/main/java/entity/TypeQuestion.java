package entity;

import entity.enumerate.PositionName;
import entity.enumerate.PositionNameConvert;
import entity.enumerate.TypeName;
import entity.enumerate.TypeNameConvert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Salary",catalog = "TestingSystemabc")
public class TypeQuestion implements Serializable {
    private static final  long serialVersionUID = 1L;

    @Column(name = "TypeID")
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private short typeID;

    @Column(name="TypeName", nullable = false,unique = true)
    @Convert(converter = TypeNameConvert.class)
    private TypeName typeName;

    public short getTypeID() {
        return typeID;
    }

    public void setTypeID(short typeID) {
        this.typeID = typeID;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName=" + typeName +
                '}';
    }

}
