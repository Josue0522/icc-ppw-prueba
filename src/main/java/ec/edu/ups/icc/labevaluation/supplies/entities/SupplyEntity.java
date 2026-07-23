package ec.edu.ups.icc.labevaluation.supplies.entities;

import java.math.BigDecimal;
import ec.edu.ups.icc.labevaluation.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
              @Table(name = "supplies")
              public class SupplyEntity extends BaseEntity {

              @Column(nullable = false, unique = true, length = 120)
              private String name;

              @Column(length = 250)
              private String description;

              @Column(nullable = false)
              private Integer quantity;

              @Column(name = "minimum_stock", nullable = false)
              private Integer minimumStock;

              @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
              private BigDecimal unitPrice;

              @Column(nullable = false)
              private boolean active = true;

              public String getName() {
              return name;
              }

              public void setName(String name) {
              this.name = name;
              }

              public String getDescription() {
              return description;
              }

              public void setDescription(String description) {
              this.description = description;
              }

              public Integer getQuantity() {
              return quantity;
              }

              public void setQuantity(Integer quantity) {
              this.quantity = quantity;
              }

              public Integer getMinimumStock() {
              return minimumStock;
              }

              public void setMinimumStock(Integer minimumStock) {
              this.minimumStock = minimumStock;
              }

              public BigDecimal getUnitPrice() {
              return unitPrice;
              }

              public void setUnitPrice(BigDecimal unitPrice) {
              this.unitPrice = unitPrice;
              }

              public boolean isActive() {
              return active;
              }

              public void setActive(boolean active) {
              this.active = active;
              }
              }
