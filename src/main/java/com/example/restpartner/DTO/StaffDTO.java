package com.example.restpartner.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    private Integer id;

    private String staffCode; //담당자코드

    private String staffName; //담당자명

    private String Position; //직금

    private String phoneNumber; //연락처

    private String email; //이메일
}
