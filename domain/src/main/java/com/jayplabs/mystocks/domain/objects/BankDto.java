package com.jayplabs.mystocks.domain.objects;

public class BankDto {

    private String mBankName;
    private String mAccountType;

    public String getBankName() {
        return mBankName;
    }

    public void setBankName(String bankName) {
        mBankName = bankName;
    }

    public String getAccountType() {
        return mAccountType;
    }

    public void setAccountType(String accountType) {
        mAccountType = accountType;
    }
}
