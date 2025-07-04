package com.example.restpartner.Controller.User;

import com.example.restpartner.DTO.UserDTO;
import com.example.restpartner.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok("가입 성공");
    }
}
