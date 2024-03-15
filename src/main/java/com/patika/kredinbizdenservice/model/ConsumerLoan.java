package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ConsumerLoan extends Loan {
    private String title;

    public ConsumerLoan(String title, BigDecimal amount, Integer installment, Double interestRate, LoanType loanType) {
        super(amount, installment, interestRate, loanType);
        this.title = title;
    }
}
