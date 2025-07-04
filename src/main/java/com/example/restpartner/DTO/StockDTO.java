package com.example.restpartner.DTO;

import com.example.restpartner.Entity.AnalystEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Integer id;

    private String name; //이름

    private String market; //시장

    private Integer price; //현재가

    private Integer close; //종가

    private Integer volume; //거래량

    private AnalystDTO analyst; //담당 애널리스트
}
