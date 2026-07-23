package ec.edu.ups.icc.labevaluation.campuses.entities;
import ec.edu.ups.icc.labevaluation.core.entities.BaseEntity;
import jakarta.persistence.*;
@Entity @Table(name = "campuses")
public class CampusEntity extends BaseEntity {
    @Column(nullable=false, length=100) private String name;
    @Column(nullable=false, length=100) private String city;
    @Column(nullable=false) private boolean active;
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getCity(){return city;} public void setCity(String city){this.city=city;}
    public boolean isActive(){return active;} public void setActive(boolean active){this.active=active;}
}
