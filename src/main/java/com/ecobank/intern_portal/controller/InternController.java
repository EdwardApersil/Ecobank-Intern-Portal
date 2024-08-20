package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.InternDto;
import com.ecobank.intern_portal.service.InternService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/intern-portal/v1")
public class InternController {

    private final InternService internService;

    @PostMapping("/intern/create")
    public ResponseEntity<InternDto> addIntern(@RequestBody InternDto internDto) {
        InternDto savedIntern = internService.addIntern(internDto);
        return ResponseEntity.ok(savedIntern);
    }

    @GetMapping("/intern/{id}")
    public ResponseEntity<InternDto> getInternById(@PathVariable("id") Long id) {
        InternDto internById = internService.getInternById(id);
        return ResponseEntity.ok(internById);
    }

//    Get all interns
    @GetMapping("/intern/all")
    public ResponseEntity<Iterable<InternDto>> getAllInterns() {
        Iterable<InternDto> allInterns = internService.getAllInterns();
        return ResponseEntity.ok(allInterns);
    }

    @PutMapping("/intern/{id}")
    public ResponseEntity<InternDto> updateIntern(@PathVariable("id") Long id, @RequestBody InternDto updatedInternDto) {
        InternDto updatedIntern = internService.updateIntern(id, updatedInternDto);
        return ResponseEntity.ok(updatedIntern);
    }

    @DeleteMapping("/intern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable("id") Long id) {
        internService.deleteIntern(id);
        return ResponseEntity.ok("Intern deleted successfully");
    }

}
