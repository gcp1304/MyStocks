package com.jayplabs.mystocks.data.entity;

import java.util.Date;
import lombok.Data;

@Data
public class StockEntity {

    public String stockId;

    public Date date;

    private String activity;

    private Integer quantity;

    private String symbol;

    private String description;

    private Float price;

    private Float commission;

    private Float fees;

    private Float amount;

}
