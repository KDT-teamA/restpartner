package com.example.restpartner.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalystEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer experience;

    @Column
    private String company;

    @Column
    private Integer avgAnnual;

    @OneToMany(mappedBy = "analyst", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<StockEntity> stockList;
}
