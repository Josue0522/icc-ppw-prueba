package ec.edu.ups.icc.labevaluation.supplies.dtos;

              import java.math.BigDecimal;

              public record SupplyResponseDto(
              Long id,
              String name,
              String description,
              Integer quantity,
              Integer minimumStock,
              BigDecimal unitPrice,
              Boolean active) {
              }