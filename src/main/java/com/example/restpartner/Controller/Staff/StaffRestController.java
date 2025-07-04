package com.example.restpartner.Controller.Staff;

import com.example.restpartner.DTO.StaffDTO;
import com.example.restpartner.Service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/staff")
public class StaffRestController {

    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody StaffDTO staffDTO) {
        staffService.create(staffDTO);
        return ResponseEntity.ok("등록 성공");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody StaffDTO staffDTO) {
        staffService.update(id, staffDTO);
        return ResponseEntity.ok("수정 성공");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        staffService.delete(id);
        return ResponseEntity.ok("삭제 성공");
    }
}