package com.jayplabs.mystocks.domain.objects;

import java.util.Date;
import lombok.Data;

@Data
public class StockDto {

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
