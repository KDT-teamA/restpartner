package com.example.restpartner.Controller.Stock;

import com.example.restpartner.Service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockViewController {

    private final StockService stockService;

    @GetMapping("/{id}")
    public String read(@PathVariable Integer id, Model model) {
        model.addAttribute(stockService.read(id));

        return "stock/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute(stockService.read(id));

        return "stock/form";
    }
}
