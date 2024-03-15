package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VehicleStatusType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class VehicleLoan extends Loan {
    private String title;
    private VehicleStatusType vehicleStatusType;

    public VehicleLoan(String title, VehicleStatusType vehicleStatusType, BigDecimal amount, Integer installment, Double interestRate, LoanType loanType) {
        super(amount, installment, interestRate, loanType);
        this.title = title;
        this.vehicleStatusType = vehicleStatusType;
    }
}
