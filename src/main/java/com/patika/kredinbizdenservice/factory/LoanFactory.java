package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VehicleStatusType;
import com.patika.kredinbizdenservice.model.Product;

import java.math.BigDecimal;

public interface LoanFactory {
    Product createLoan(LoanType type, String title, BigDecimal amount, Integer installment, Double interestRate, VehicleStatusType vehicleStatusType);
}
