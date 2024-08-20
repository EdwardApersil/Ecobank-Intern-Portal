package com.ecobank.intern_portal.controller;

import com.ecobank.intern_portal.dto.ComplaintDto;
import com.ecobank.intern_portal.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/intern-portal/v1")
public class ComplaintController {

    private final ComplaintService complaintService;

//    PostMapping
    @PostMapping("/complaint")
    public ResponseEntity<ComplaintDto> createComplaint(@RequestBody ComplaintDto complaintDto) {
        ComplaintDto saveComplaint = complaintService.createComplaint(complaintDto);
        return ResponseEntity.ok(saveComplaint);
    }

    // GetMapping
    @GetMapping("/complaint/{id}")
    public ResponseEntity<ComplaintDto> getComplaintById(@PathVariable("id") Long id) {
        ComplaintDto complaintById = complaintService.getComplaintById(id);
        return ResponseEntity.ok(complaintById);
    }

    // PutMapping
    @PutMapping("/complaint/{id}")
    public ResponseEntity<ComplaintDto> updateComplaint(@PathVariable("id") Long id, @RequestBody ComplaintDto updatedComplaintDto) {
        ComplaintDto updatedComplaint = complaintService.updateComplaint(id, updatedComplaintDto);
        return ResponseEntity.ok(updatedComplaint);
    }

//    GetMapping All complaints
    @GetMapping("/complaint/all")
    public ResponseEntity<List<ComplaintDto>> getAllComplaints() {
        List<ComplaintDto> allComplaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(allComplaints);
    }

//    delete
    @DeleteMapping("/complaint/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable("id") Long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.ok("Complaint deleted successfully");
    }



}
