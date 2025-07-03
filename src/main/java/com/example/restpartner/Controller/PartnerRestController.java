package com.example.restpartner.Controller;

import com.example.restpartner.DTO.PartnerDTO;
import com.example.restpartner.Service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PrinterStateReason;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/partner")
public class PartnerRestController {

    private final PartnerService partnerService;

    //전체조회처리
    @GetMapping()
    public ResponseEntity<List<PartnerDTO>> get() {
        return ResponseEntity.ok(partnerService.getAllPartners());
    }
    
    //개별조회처리
    @GetMapping("/{id}")
    public ResponseEntity<PartnerDTO> getPartnerById(@PathVariable Integer id) {
        PartnerDTO partner = partnerService.getPartnerById(id);

        return partner != null ? ResponseEntity.ok(partner) : ResponseEntity.notFound().build();
    }

    //삽입처리
    @PostMapping()
    public ResponseEntity<PartnerDTO> createPartner(@RequestBody PartnerDTO partnerDTO) {
        PartnerDTO partner = partnerService.createPartner(partnerDTO);
        return ResponseEntity.ok(partner);
    }
    
    //수정처리
    @PutMapping("/{id}")
    public ResponseEntity<PartnerDTO> updatePartner(@PathVariable Integer id, @RequestBody PartnerDTO partnerDTO) {
        PartnerDTO partner = partnerService.updatePartner(id, partnerDTO);

        return partner != null ? ResponseEntity.ok(partner) : ResponseEntity.notFound().build();
    }
    
    //삭제처리
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Integer id) {
        partnerService.deletePartner(id);
        return ResponseEntity.ok().build();
    }
}