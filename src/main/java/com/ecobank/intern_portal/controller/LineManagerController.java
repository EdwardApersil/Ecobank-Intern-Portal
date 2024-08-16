package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.LineManagerDto;
import com.ecobank.intern_portal.service.LineManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/intern-portal/v1")
public class LineManagerController {

    private LineManagerService lineManagerService;

    @PostMapping("/line-manager")
    public ResponseEntity<LineManagerDto> addLineManager(@RequestBody LineManagerDto lineManagerDto) {
        LineManagerDto savedLineManager = lineManagerService.addLineManager(lineManagerDto);
        return ResponseEntity.ok(savedLineManager);
    }

    @PutMapping("/line-manager/{id}")
    public ResponseEntity<LineManagerDto> updateLineManager(@PathVariable("id") Long id, @RequestBody LineManagerDto lineManagerDto) {
        LineManagerDto updatedLineManager = lineManagerService.updateLineManager(id, lineManagerDto);
        return ResponseEntity.ok(updatedLineManager);
    }

    @GetMapping("/line-manager/{id}")
    public ResponseEntity<LineManagerDto> getLineManagerById(@PathVariable("id") Long id) {
        LineManagerDto lineManagerById = lineManagerService.getLineManagerById(id);
        return ResponseEntity.ok(lineManagerById);
    }

//    get all line managers
    @GetMapping("/line-manager")
    public ResponseEntity<Iterable<LineManagerDto>> getAllLineManagers() {
        Iterable<LineManagerDto> allLineManagers = lineManagerService.getAllLineManagers();
        return ResponseEntity.ok(allLineManagers);
    }

    @DeleteMapping("/line-manager/{id}")
    public ResponseEntity<String> deleteLineManager(@PathVariable("id") Long id) {
        lineManagerService.deleteLineManager(id);
        return ResponseEntity.ok("Line Manager deleted successfully");
    }


}