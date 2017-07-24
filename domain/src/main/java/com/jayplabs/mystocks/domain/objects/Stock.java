package com.jayplabs.mystocks.domain.objects;

import java.util.Date;

public class Stock {

    private String mSymbol;
    private String mName;
    private String mTransactionType;
    private Date mTransactionDate;
    private int mQuantity;
    private String mTransactionPrice;
    private String mCost;
    private String mGrantType;
    private String mBroker;
    private String mBrokerage;
    private String mTax;
    private String mTotalCost;
    private String mProfitOrLoss;

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

    public String getTransactionPrice() {
        return mTransactionPrice;
    }

    public void setTransactionPrice(String transactionPrice) {
        mTransactionPrice = transactionPrice;
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

    public String getProfitOrLoss() {
        return mProfitOrLoss;
    }

    public void setProfitOrLoss(String profitOrLoss) {
        mProfitOrLoss = profitOrLoss;
    }
}
