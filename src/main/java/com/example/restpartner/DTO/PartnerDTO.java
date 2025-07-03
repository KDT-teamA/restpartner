package com.example.restpartner.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerDTO {
    private Integer id;

    private String partnerCode; //거래처코드

    private String partnerName; //거래처명

    private String startDate; //거래시작일

    private Integer quantity; //거래수량

    private Integer unitPrice; //거래가격

    private String managerCode; //담당자코드
}
