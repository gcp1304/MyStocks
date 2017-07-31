package com.jayplabs.mystocks.presentation.mvp.model;

import java.util.Date;

public class StockModel {

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

    public StockModel() {
    }

    public StockModel(final String stockId) {
        mStockId = stockId;
    }

    public String getStockId() {
        return mStockId;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(final String symbol) {
        mSymbol = symbol;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
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

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(final int quantity) {
        mQuantity = quantity;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(final String price) {
        mPrice = price;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(final String cost) {
        mCost = cost;
    }

    public String getGrantType() {
        return mGrantType;
    }

    public void setGrantType(final String grantType) {
        mGrantType = grantType;
    }

    public String getBroker() {
        return mBroker;
    }

    public void setBroker(final String broker) {
        mBroker = broker;
    }

    public String getBrokerage() {
        return mBrokerage;
    }

    public void setBrokerage(final String brokerage) {
        mBrokerage = brokerage;
    }

    public String getTax() {
        return mTax;
    }

    public void setTax(final String tax) {
        mTax = tax;
    }

    public String getTotalCost() {
        return mTotalCost;
    }

    public void setTotalCost(final String totalCost) {
        mTotalCost = totalCost;
    }
}
