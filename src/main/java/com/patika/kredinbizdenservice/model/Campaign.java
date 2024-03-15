package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.SectorType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Campaign {
    private String title;
    private String content;
    private LocalDate dueDate;
    private SectorType sectorType;
    private List<Product> creditCards;

    public Campaign(String title, String content, LocalDate dueDate, SectorType sectorType) {
        this.title = title;
        this.content = content;
        this.dueDate = dueDate;
        this.sectorType = sectorType;
    }
}
