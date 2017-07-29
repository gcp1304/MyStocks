package com.jayplabs.mystocks.domain.objects;

public class ProfileDto {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private BankDto[] mBankDtoAccount;
    private String mBroker;
    private BrokerDto[] mBrokerageCost;

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

    public BankDto[] getBankDtoAccount() {
        return mBankDtoAccount;
    }

    public void setBankDtoAccount(BankDto[] bankDtoAccount) {
        mBankDtoAccount = bankDtoAccount;
    }

    public String getBroker() {
        return mBroker;
    }

    public void setBroker(String broker) {
        mBroker = broker;
    }

    public BrokerDto[] getBrokerageCost() {
        return mBrokerageCost;
    }

    public void setBrokerageCost(BrokerDto[] brokerageCost) {
        mBrokerageCost = brokerageCost;
    }
}
