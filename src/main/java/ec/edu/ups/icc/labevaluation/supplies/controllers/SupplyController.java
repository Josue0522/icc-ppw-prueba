package ec.edu.ups.icc.labevaluation.supplies.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ec.edu.ups.icc.labevaluation.supplies.dtos.CreateSupplyDto;
import ec.edu.ups.icc.labevaluation.supplies.dtos.SupplyResponseDto;
import ec.edu.ups.icc.labevaluation.supplies.dtos.UpdateSupplyQuantityDto;
import ec.edu.ups.icc.labevaluation.supplies.services.SupplyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/supplies")
public class SupplyController {

    private final SupplyService service;

    public SupplyController(SupplyService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINATOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public SupplyResponseDto create(@Valid @RequestBody CreateSupplyDto dto) {
        return service.create(dto);
    }

    @GetMapping("/low-stock")
    @PreAuthorize("isAuthenticated()")
    public List<SupplyResponseDto> findLowStock(@RequestParam(defaultValue = "10") Integer maxQuantity) {
        return service.findLowStock(maxQuantity);
    }

    @PatchMapping("/{id}/quantity")
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINATOR')")
    public SupplyResponseDto updateQuantity(@PathVariable Long id, @Valid @RequestBody UpdateSupplyQuantityDto dto) {
        return service.updateQuantity(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINATOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}