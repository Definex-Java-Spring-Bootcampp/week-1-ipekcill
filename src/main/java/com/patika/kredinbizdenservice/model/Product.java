package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;

public interface Product {
    BigDecimal getAmount();

    LoanType getLoanType();

    void setBank(Bank bank);

    Bank getBank();
    String getName();

}
