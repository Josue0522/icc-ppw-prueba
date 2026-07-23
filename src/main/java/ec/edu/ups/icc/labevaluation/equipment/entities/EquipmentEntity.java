package ec.edu.ups.icc.labevaluation.equipment.entities;
import ec.edu.ups.icc.labevaluation.core.entities.BaseEntity;
import jakarta.persistence.*;
@Entity @Table(name="equipment")
public class EquipmentEntity extends BaseEntity {
    @Column(nullable=false, unique=true, length=100) private String name;
    @Column(nullable=false) private boolean active;
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public boolean isActive(){return active;} public void setActive(boolean active){this.active=active;}
}
