package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payment.Payment;
import br.com.erick.lara.payments.domain.payment.PaymentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class AccountBalanceTest {

    private Payment payment;

    @BeforeEach
    void createBalance(){
        this.payment = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10")
                .withValue(new BigDecimal(6))
                .create();
    }

    @Test
    @DisplayName("Test must work with a valid account balance.")
    void validatePaymentsWithValidAccountBalances() {
        assertAll(() ->  new AccountBalance(BigDecimal.TEN, this.payment).validatePayment());
        assertAll(() ->  new AccountBalance(new BigDecimal(6), this.payment).validatePayment());
        assertAll(() ->  new AccountBalance(new BigDecimal(20), this.payment).validatePayment());
    }

    @Test
    @DisplayName("Test must fail with a invalid account balance.")
    void validatePaymentsWithInvalidAccountBalances() {
        assertThrows(ArithmeticException.class, () -> new AccountBalance(BigDecimal.ZERO, this.payment).validatePayment());
        assertThrows(ArithmeticException.class, () -> new AccountBalance(new BigDecimal(2), this.payment).validatePayment());
        assertThrows(IllegalArgumentException.class, () -> new AccountBalance(null, this.payment).validatePayment());
    }
}