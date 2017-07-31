package com.jayplabs.mystocks.domain.objects;

import java.util.Date;
import java.util.UUID;

public class StockDto {

    private String mStockId;
    private String mSymbol;
    private String mName;
    private String mTransactionType;
    private Date mTransactionDate;
    private int mQuantity;
    private String mPrice;
    private String mCost;
    private String mGrantType;
    private String mBroker;
    private String mBrokerage;
    private String mTax;
    private String mTotalCost;

    /**
     * This constructor should be used when we are converting an already existing trade item
     * to Entity, so we already have an id variable
     */
    public StockDto(String stockId) {
        mStockId = stockId;
    }

    public StockDto() {
        // trade will be "uniquely" identified by this random UUID
        mStockId = createStockID();
    }

    public String getStockId() {
        return mStockId;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
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

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(String cost) {
        mCost = cost;
    }

    public String getGrantType() {
        return mGrantType;
    }

    public void setGrantType(String grantType) {
        mGrantType = grantType;
    }

    public String getBroker() {
        return mBroker;
    }

    public void setBroker(String broker) {
        mBroker = broker;
    }

    public String getBrokerage() {
        return mBrokerage;
    }

    public void setBrokerage(String brokerage) {
        mBrokerage = brokerage;
    }

    public String getTax() {
        return mTax;
    }

    public void setTax(String tax) {
        mTax = tax;
    }

    public String getTotalCost() {
        return mTotalCost;
    }

    public void setTotalCost(String totalCost) {
        mTotalCost = totalCost;
    }

    private String createStockID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StockDto stockDto = (StockDto) obj;
        return mStockId.equals(stockDto.getStockId());
    }

    @Override
    public int hashCode() {
        return (int) (Long.valueOf(mStockId) ^ (Long.valueOf(mStockId) >>> 32));
    }
}
