package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.Product;

import java.math.BigDecimal;

public class CreditCardFactory {
    public Product createCreditCard(String name, BigDecimal fee, BigDecimal limit) {
        return new CreditCard(name, fee, limit);
    }
}
