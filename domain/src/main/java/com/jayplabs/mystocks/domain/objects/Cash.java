package com.jayplabs.mystocks.domain.objects;

import java.util.Date;

public class Cash {

    private String mTransactionType;
    private Date mTransactionDate;
    private String mAmount;

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
