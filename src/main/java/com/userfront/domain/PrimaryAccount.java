package com.userfront.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class PrimaryAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PrimaryTransaction> primaryTransactionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<PrimaryTransaction> getPrimaryTransactionList() {
        return primaryTransactionList;
    }

    public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
        this.primaryTransactionList = primaryTransactionList;
    }

    public PrimaryAccount() {
    }

    public PrimaryAccount( Long id, int accountNumber, BigDecimal accountBalance  ,List<PrimaryTransaction> primaryTransactionList) {
        this.id= id;
        this.accountNumber= accountNumber;
        this.accountBalance= accountBalance;
        this.primaryTransactionList= primaryTransactionList;
    }

    public PrimaryAccount( Long id, int accountNumber, BigDecimal accountBalance )  {
        this.id= id;
        this.accountNumber= accountNumber;
        this.accountBalance= accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimaryAccount that = (PrimaryAccount) o;
        return accountNumber == that.accountNumber &&
                Objects.equals(id, that.id) &&
                Objects.equals(accountBalance, that.accountBalance) &&
                Objects.equals(primaryTransactionList, that.primaryTransactionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, accountBalance, primaryTransactionList);
    }
}



