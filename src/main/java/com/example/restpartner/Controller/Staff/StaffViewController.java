package com.example.restpartner.Controller.Staff;

import com.example.restpartner.DTO.StaffDTO;
import com.example.restpartner.Service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffViewController {

    private final StaffService staffService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new StaffDTO());

        return "staff/form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute(staffService.list());

        return "staff/list";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable Integer id, Model model){
        model.addAttribute(staffService.read(id));

        return "staff/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute(staffService.read(id));

        return "staff/form";
    }
}
