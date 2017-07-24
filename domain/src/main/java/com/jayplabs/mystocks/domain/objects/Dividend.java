package com.jayplabs.mystocks.domain.objects;

import java.util.Date;

public class Dividend {

    private String mSymbol;
    private String mName;
    private Date mDate;
    private String mAmount;
    private int mNumberOfStocksHeld;

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

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public int getNumberOfStocksHeld() {
        return mNumberOfStocksHeld;
    }

    public void setNumberOfStocksHeld(int numberOfStocksHeld) {
        mNumberOfStocksHeld = numberOfStocksHeld;
    }
}
