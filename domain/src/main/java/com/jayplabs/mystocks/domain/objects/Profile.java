package com.jayplabs.mystocks.domain.objects;

public class Profile {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mBankAccount;
    private String mBroker;
    private String mBrokerageCost;

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

    public String getBrokerageCost() {
        return mBrokerageCost;
    }

    public void setBrokerageCost(String brokerageCost) {
        mBrokerageCost = brokerageCost;
    }
}
