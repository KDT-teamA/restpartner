package com.example.restpartner.Controller.Analyst;

import com.example.restpartner.DTO.AnalystDTO;
import com.example.restpartner.Service.AnalystService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analyst")
public class AnalystRestController {

    private final AnalystService analystService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AnalystDTO analystDTO) {
        analystService.create(analystDTO);

        return ResponseEntity.ok("등록 성공");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id ,@RequestBody AnalystDTO analystDTO) {
        analystService.update(id, analystDTO);

        return ResponseEntity.ok("수정 성공");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        analystService.delete(id);

        return ResponseEntity.ok("삭제 성공");
    }
}
