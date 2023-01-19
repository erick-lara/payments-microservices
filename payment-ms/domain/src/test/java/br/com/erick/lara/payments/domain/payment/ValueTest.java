package br.com.erick.lara.payments.domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ValueTest {

    @Test
    @DisplayName("Test must fail with invalid values.")
    void mustFailWithInvalidValues(){
        assertThrows(IllegalArgumentException.class, () -> new Value(null));
        assertThrows(IllegalArgumentException.class, () -> new Value(BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () -> new Value(new BigDecimal(-1)));
    }
}