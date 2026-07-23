package ec.edu.ups.icc.labevaluation.supplies.dtos;

              import java.math.BigDecimal;

              import jakarta.validation.constraints.DecimalMin;
              import jakarta.validation.constraints.Min;
              import jakarta.validation.constraints.NotBlank;
              import jakarta.validation.constraints.NotNull;
              import jakarta.validation.constraints.Size;

              public record CreateSupplyDto(
              @NotBlank @Size(max = 120) String name,
              @Size(max = 250) String description,
              @NotNull @Min(0) Integer quantity,
              @NotNull @Min(0) Integer minimumStock,
              @NotNull @DecimalMin(value = "0.01") BigDecimal unitPrice) {
              }