package com.example.restpartner.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String partnerCode; //거래처코드

    @Column
    private String partnerName; //거래처명

    @Column
    private String startDate; //거래시작일

    @Column
    private Integer quantity; //거래수량

    @Column
    private Integer unitPrice; //거래가격

    @Column
    private String managerCode; //담당자코드
}
