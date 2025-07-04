package com.example.restpartner.DTO;

import com.example.restpartner.Entity.StockEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalystDTO {

    private Integer id;

    private String name; //이름

    private Integer experience; //경력

    private String company; //소속

    private Integer avgAnnual; //연평균수익률

    private List<StockDTO> stockList; //종목리스트
}
