package com.ecobank.intern_portal.service.implementations;

import com.ecobank.intern_portal.dto.InternDto;
import com.ecobank.intern_portal.mapper.InternMapper;
import com.ecobank.intern_portal.model.Department;
import com.ecobank.intern_portal.model.Intern;
import com.ecobank.intern_portal.model.LineManagers;
import com.ecobank.intern_portal.repository.DepartmentRespository;
import com.ecobank.intern_portal.repository.InternRespository;
import com.ecobank.intern_portal.repository.LineManagerRespository;
import com.ecobank.intern_portal.service.InternService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InternImplement implements InternService {
    private InternRespository internRespository;
    private LineManagerRespository lineManagerRespository;
    private DepartmentRespository departmentRespository;

    /**
 * This method is responsible for adding a new intern to the system.
 *
 * @param internDto The DTO object containing the details of the intern to be added.
 *                  This object should be non-null and should contain valid data.
 *
 * @return The DTO object representing the newly added intern.
 *         This object will be non-null and will contain the unique identifier of the intern.
 *
 * @throws IllegalArgumentException If the provided internDto is null.
     */
    @Override
    public InternDto addIntern(InternDto internDto) {
        if (internDto == null) {
            throw new IllegalArgumentException("The internDto cannot be null.");
        }
        LineManagers lineManager = lineManagerRespository.findById(internDto.getLineManagerId())
                .orElseThrow(() -> new RuntimeException("LineManager with id: " + internDto.getLineManagerId() + " not found"));

        Department department = departmentRespository.findById(internDto.getDepartment())
                .orElseThrow(() -> new RuntimeException("Department with id: " + internDto.getDepartment() + " not found"));

        Intern intern = InternMapper.mapToIntern(internDto);
        intern.setLineManager(lineManager);
        intern.setDepartment(department);
        Intern savedIntern = internRespository.save(intern);
        return InternMapper.mapToInternDto(savedIntern);
    }

    @Override
    public InternDto getInternById(Long id) {
        Intern intern = internRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern with id: " + id + " not found"));
        return InternMapper.mapToInternDto(intern);
    }

    @Override
    public InternDto updateIntern(Long id, InternDto updatedInternDto) {
        Intern intern = internRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Intern with id: " + id + " not found"));
        intern.setFirstName(updatedInternDto.getFirstName());
        intern.setLastName(updatedInternDto.getLastName());
        intern.setEmail(updatedInternDto.getEmail());
        intern.setPassword(updatedInternDto.getPassword());
        Intern updatedIntern = internRespository.save(intern);
        return InternMapper.mapToInternDto(updatedIntern);
    }

//    Get all interns
    @Override
    public List<InternDto> getAllInterns() {
        List<Intern> Intern = internRespository.findAll();
        return Intern.stream().map(InternMapper::mapToInternDto).collect(Collectors.toList());
    }

    @Override
    public void deleteIntern(Long id) {
        internRespository.deleteById(id);
    }
}
