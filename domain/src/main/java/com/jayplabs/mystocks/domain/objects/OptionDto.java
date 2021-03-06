package com.jayplabs.mystocks.domain.objects;

import java.util.Date;

public class OptionDto {

    private String mSymbol; // E.g FB Dec 15 2017 $180 Call
    private String mName;
    private String mContractType;
    private String mTransactionType;
    private String mNumberOfContracts;
    private String mAvgPrice;
    private String mCost;
    private Date mTransactionDate;
    private String mStrikePrice;
    private Date mExpiryDate;
    private String mBroker;
    private String mBrokerage;
    private String mTax;
    private String mTotalCost;

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

    public String getContractType() {
        return mContractType;
    }

    public void setContractType(String contractType) {
        mContractType = contractType;
    }

    public String getTransactionType() {
        return mTransactionType;
    }

    public void setTransactionType(String transactionType) {
        mTransactionType = transactionType;
    }

    public String getNumberOfContracts() {
        return mNumberOfContracts;
    }

    public void setNumberOfContracts(String numberOfContracts) {
        mNumberOfContracts = numberOfContracts;
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

    public Date getTransactionDate() {
        return mTransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        mTransactionDate = transactionDate;
    }

    public String getStrikePrice() {
        return mStrikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        mStrikePrice = strikePrice;
    }

    public Date getExpiryDate() {
        return mExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        mExpiryDate = expiryDate;
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
