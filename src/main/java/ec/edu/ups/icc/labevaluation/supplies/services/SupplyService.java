package ec.edu.ups.icc.labevaluation.supplies.services;

import java.util.List;
import ec.edu.ups.icc.labevaluation.supplies.dtos.CreateSupplyDto;
import ec.edu.ups.icc.labevaluation.supplies.dtos.SupplyResponseDto;
import ec.edu.ups.icc.labevaluation.supplies.dtos.UpdateSupplyQuantityDto;

public interface SupplyService {
    SupplyResponseDto create(CreateSupplyDto dto);
    List<SupplyResponseDto> findLowStock(Integer maxQuantity);
    SupplyResponseDto updateQuantity(Long id, UpdateSupplyQuantityDto dto);
    void delete(Long id);
}