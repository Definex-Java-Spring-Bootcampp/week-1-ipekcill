package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HouseLoan extends Loan {
    private String title;

    public HouseLoan(String title, BigDecimal amount, Integer installment, Double interestRate, LoanType loanType) {
        super(amount, installment, interestRate, loanType);
        this.title = title;
    }

    @Override
    public String toString() {
        return "HouseLoan{" +
                "title='" + title + '\'' +
                ", amount = " + getAmount() +
                ", installment = " + getInstallment() +
                ", interestRate = " + getInterestRate() +
                ", loanType = " + getLoanType() +
                ", bank = " + getBank() +
                '}';

    }

}
