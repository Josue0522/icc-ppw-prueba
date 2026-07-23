package ec.edu.ups.icc.labevaluation.laboratories.entities;

import java.util.HashSet;
import java.util.Set;
import ec.edu.ups.icc.labevaluation.campuses.entities.CampusEntity;
import ec.edu.ups.icc.labevaluation.core.entities.BaseEntity;
import ec.edu.ups.icc.labevaluation.equipment.entities.EquipmentEntity;
import jakarta.persistence.*;

@Entity @Table(name="laboratories")
public class LaboratoryEntity extends BaseEntity {
    @Column(nullable=false, unique=true, length=30) private String code;
    @Column(nullable=false, length=120) private String name;
    @Column(nullable=false) private Integer capacity;
    @Column(nullable=false) private boolean active;
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="campus_id", nullable=false)
    private CampusEntity campus;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="laboratory_equipment", joinColumns=@JoinColumn(name="laboratory_id"), inverseJoinColumns=@JoinColumn(name="equipment_id"))
    private Set<EquipmentEntity> equipment = new HashSet<>();
    public String getCode(){return code;} public void setCode(String code){this.code=code;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public Integer getCapacity(){return capacity;} public void setCapacity(Integer capacity){this.capacity=capacity;}
    public boolean isActive(){return active;} public void setActive(boolean active){this.active=active;}
    public CampusEntity getCampus(){return campus;} public void setCampus(CampusEntity campus){this.campus=campus;}
    public Set<EquipmentEntity> getEquipment(){return equipment;} public void setEquipment(Set<EquipmentEntity> equipment){this.equipment=equipment;}
}
