package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class Loan implements Product {
    private LoanType loanType;
    private BigDecimal amount;
    private Integer installment;
    private Double interestRate;
    private Bank bank;
    private String name;

    public Loan(BigDecimal amount, Integer installment, Double interestRate, LoanType loanType) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
        this.loanType = loanType;
    }

    public Loan() {
    }
}
