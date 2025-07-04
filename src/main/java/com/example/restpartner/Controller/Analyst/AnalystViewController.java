package com.example.restpartner.Controller.Analyst;

import com.example.restpartner.DTO.AnalystDTO;
import com.example.restpartner.DTO.StockDTO;
import com.example.restpartner.Service.AnalystService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/analyst")
public class AnalystViewController {

    private final AnalystService analystService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new AnalystDTO());

        return "analyst/form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute(analystService.list());

        return "analyst/list";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable Integer id, Model model) {
        model.addAttribute(analystService.read(id));
        model.addAttribute(new StockDTO());

        return "analyst/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute(analystService.read(id));

        return "analyst/form";
    }
}
