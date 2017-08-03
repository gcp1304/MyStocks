package com.jayplabs.mystocks.data.entity.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import java.util.Date;
import java.util.UUID;


public class RealmStockEntity extends RealmObject {

    private String mStockId;

    @Required
    private String mSymbol;

    private String mName;

    @Required
    private String mTransactionType;

    @Required
    private Date mTransactionDate;

    private int mQuantity;

    @Required
    private String mAvgPrice;

    private String mCost;

    private String mGrantType;

    private String mBroker;

    private String mBrokerage;

    private String mTax;

    private String mTotalCost; // mCost + mBrokerage + mTax

    public RealmStockEntity() {
    }

    public RealmStockEntity(final String stockId) {
        mStockId = stockId;
    }

    public String getStockId() {
        return mStockId;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
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

    public String getAvgPrice() {
        return mAvgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        mAvgPrice = avgPrice;
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

}