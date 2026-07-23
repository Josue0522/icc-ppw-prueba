package ec.edu.ups.icc.labevaluation.supplies.dtos;

              import jakarta.validation.constraints.Min;
              import jakarta.validation.constraints.NotNull;

              public record UpdateSupplyQuantityDto(
              @NotNull @Min(0) Integer quantity) {
              }