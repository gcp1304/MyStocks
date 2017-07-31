package com.jayplabs.mystocks.domain.objects;

import java.util.Date;
import java.util.UUID;

public class CashDto {

    private final String mTransactionId;
    private String mTransactionType;
    private Date mTransactionDate;
    private String mAmount;

    /**
     * This constructor should be used when we are converting an already existing transaction item
     * to Entity, so we already have an id variable
     */
    public CashDto(String transactionId) {
        mTransactionId = transactionId;
    }

    public CashDto() {
        // transaction will be "uniquely" identified by this random UUID
        mTransactionId = createTransactionID();
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

    private String createTransactionID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        CashDto cashDto = (CashDto) obj;

        return mTransactionId.equals(cashDto.getTransactionId());
    }

    @Override
    public int hashCode() {
        return (int) (Long.valueOf(mTransactionId) ^ (Long.valueOf(mTransactionId) >>> 32));
    }
}
