package br.com.erick.lara.payments.domain.payment;

import java.math.BigDecimal;

public record Value(BigDecimal totalValue) {

    public Value {
        if (validateValue(totalValue)) {
            throw new IllegalArgumentException("Invalid value for payment.");
        }
    }

    private boolean validateValue(BigDecimal value) {
        return value == null || value.equals(BigDecimal.ZERO) || value.intValue() < 0;
    }
}
