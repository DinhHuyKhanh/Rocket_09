package entity;

import entity.enumerate.PositionName;
import entity.enumerate.PositionNameConvert;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Position", catalog = "TestingSystemabc")
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private short positionId;

    @Column(name="PositionName", nullable = false,unique = true)
    @Convert(converter = PositionNameConvert.class)
    private PositionName positionName;


    public short getPositionId() {
        return positionId;
    }

    public void setPositionId(short positionId) {
        this.positionId = positionId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName=" + positionName +
                '}';
    }
}
