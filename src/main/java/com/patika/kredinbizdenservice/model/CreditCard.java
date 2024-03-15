package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class CreditCard implements Product {
    private String name;
    private BigDecimal fee;
    private BigDecimal limit;
    private Bank bank;
    private List<Campaign> campaigns;
    private final LoanType loanType;


    public CreditCard(String name, BigDecimal fee, BigDecimal limit) {
        this.name = name;
        this.fee = fee;
        this.limit = limit;
        this.loanType = LoanType.CREDIT_CARD;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    @Override
    public BigDecimal getAmount() {
        return limit;
    }

    @Override
    public LoanType getLoanType() {
        return this.loanType;
    }

    @Override
    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
