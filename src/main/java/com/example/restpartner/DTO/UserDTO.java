package com.example.restpartner.DTO;

import com.example.restpartner.Constant.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private Level level;
}
