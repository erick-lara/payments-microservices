package br.com.erick.lara.payments.domain.payment;


import java.math.BigDecimal;

public class AccountBalance {

    private BigDecimal totalValue;

    public AccountBalance(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getValue() {
        return totalValue;
    }

    public void subtractBalance(BigDecimal value){
        if(totalValue.intValue() < value.intValue()){
            throw new ArithmeticException("Insufficient funds.");
        }
        totalValue = totalValue.subtract(value);
    }

    public void addBalance(BigDecimal value){
        totalValue = totalValue.add(value);
    }
}
