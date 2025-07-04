package com.example.restpartner.Controller.User;

import com.example.restpartner.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(new UserDTO());

        return "register";
    }
}
