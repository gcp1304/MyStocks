package com.jayplabs.mystocks.data.entity.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import java.util.Date;
import java.util.UUID;


public class RealmCashEntity extends RealmObject {

    private String mTransactionId;

    @Required
    private String mTransactionType;

    @Required
    private Date mTransactionDate;

    @Required
    private String mAmount;

    public RealmCashEntity() {
    }

    public RealmCashEntity(final String transactionId) {
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
