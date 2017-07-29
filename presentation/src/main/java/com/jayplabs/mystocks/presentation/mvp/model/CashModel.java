package com.jayplabs.mystocks.presentation.mvp.model;

import java.util.Date;

public class CashModel {

    private String mTransactionId;

    private String mTransactionType;

    private Date mTransactionDate;

    private String mAmount;

    public String getTransactionId() {
        return mTransactionId;
    }

    public void setTransactionId(final String transactionId) {
        mTransactionId = transactionId;
    }

    public String getTransactionType() {
        return mTransactionType;
    }

    public void setTransactionType(final String transactionType) {
        mTransactionType = transactionType;
    }

    public Date getTransactionDate() {
        return mTransactionDate;
    }

    public void setTransactionDate(final Date transactionDate) {
        mTransactionDate = transactionDate;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(final String amount) {
        mAmount = amount;
    }
}
