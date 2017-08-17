package com.jayplabs.mystocks.data.entity.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RealmStockEntity extends RealmObject {

    @PrimaryKey
    private String stockId;

    @Required
    public Date date;

    @Required
    private String activity;

    @Required
    private Integer quantity;

    @Required
    private String symbol;

    private String description;

    @Required
    private Float price;

    private Float commission;

    private Float fees;

    private Float amount;

}