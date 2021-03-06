package com.jayplabs.mystocks.data.entity;

import com.jayplabs.mystocks.common.data.entity.Entity;
import java.util.Date;
import java.util.UUID;

public class CashEntity implements Entity {

    private String mTransactionId;

    private String mTransactionType;

    private Date mTransactionDate;

    private String mAmount;

    public void setTransactionId(String transactionId) {
        mTransactionId = transactionId;
    }

    public String getTransactionId() {
        return mTransactionId;
    }

    public String getTransactionType() {
        return mTransactionType;
    }

    public void setTransactionType(String transactionType) {
        mTransactionType = transactionType;
    }

    public Date getTransactionDate() {
        return mTransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        mTransactionDate = transactionDate;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }


}
