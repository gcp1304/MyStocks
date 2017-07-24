package com.jayplabs.mystocks.domain.objects;

public class Profile {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mBankAccount;
    private String mBroker;
    private String mBrokerage;

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getBankAccount() {
        return mBankAccount;
    }

    public void setBankAccount(String bankAccount) {
        mBankAccount = bankAccount;
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
}
