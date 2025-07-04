package com.example.restpartner.Controller.Partner;

import com.example.restpartner.DTO.PartnerDTO;
import com.example.restpartner.Service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/partner")
public class PartnerViewController {
    private final PartnerService partnerService;

    //목록페이지, /partner/list
    @GetMapping("/list")
    public String list(Model model) {
        List<PartnerDTO> partnerDTOS = partnerService.list();
        model.addAttribute("partnerDTOS", partnerDTOS);

        return "partner/list";
    }

    //등록페이지, /partner/register
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("partnerDTO", new PartnerDTO());

        return "partner/form";
    }

    //수정페이지, /partner/update/{id}
    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        PartnerDTO partnerDTO = partnerService.read(id);
        model.addAttribute("partnerDTO", partnerDTO);

        return "partner/form";
    }

    //상세페이지 /partner/detail/{id}
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        PartnerDTO partnerDTO = partnerService.read(id);
        model.addAttribute("partnerDTO", partnerDTO);

        return "partner/detail";
    }
}
