package com.example.restpartner.Controller.Stock;

import com.example.restpartner.DTO.StockDTO;
import com.example.restpartner.Service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockRestController {

    private final StockService stockService;

    @PostMapping("/{analyst_id}")
    public ResponseEntity<String> create(@PathVariable Integer analyst_id, @RequestBody StockDTO stockDTO) {
        stockService.create(analyst_id, stockDTO);

        return ResponseEntity.ok("등록 성공");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id ,@RequestBody StockDTO stockDTO) {
        stockService.update(id, stockDTO);

        return ResponseEntity.ok("수정 성공");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        stockService.delete(id);

        return ResponseEntity.ok("삭제 성공");
    }
}
