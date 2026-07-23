package ec.edu.ups.icc.labevaluation.laboratories.controllers;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ec.edu.ups.icc.labevaluation.laboratories.dtos.LaboratoryResponseDto;
import ec.edu.ups.icc.labevaluation.laboratories.services.LaboratoryService;
@RestController @RequestMapping("/laboratories")
public class LaboratoryController {
    private final LaboratoryService service;
    public LaboratoryController(LaboratoryService service){this.service=service;}
    @GetMapping("/available")
    @PreAuthorize("isAuthenticated()")
    public List<LaboratoryResponseDto> findAvailable(@RequestParam Long campusId, @RequestParam Integer minCapacity){
        return service.findAvailable(campusId, minCapacity);
    }
    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public LaboratoryResponseDto findOne(@PathVariable Long id){return service.findOne(id);}
}
