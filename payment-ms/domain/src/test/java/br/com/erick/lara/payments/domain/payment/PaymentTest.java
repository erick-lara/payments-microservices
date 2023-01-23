package br.com.erick.lara.payments.domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class PaymentTest {

    @Test
    @DisplayName("Test must work with a valid account balance.")
    void validatePaymentsWithValidAccountBalances() {
        assertAll(
                () -> PaymentBuilder
                        .build()
                        .withPayer("Erick Lara", "123.456.789-10", BigDecimal.TEN)
                        .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                        .withValue(new BigDecimal(6))
                        .create()
                        .validateAndProcessPayment()
        );
    }

    @Test
    @DisplayName("Test must fail with invalids account balances.")
    void validateProcessPayments() {
        Payment payment1 = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10", BigDecimal.TEN)
                .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                .withValue(new BigDecimal(60))
                .create();

        Payment payment2 = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10", BigDecimal.TEN)
                .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                .withValue(new BigDecimal(13))
                .create();

        Payment payment3 = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10", null)
                .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                .withValue(new BigDecimal(60))
                .create();

        assertThrows(ArithmeticException.class, payment1::validateAndProcessPayment);
        assertThrows(ArithmeticException.class, payment2::validateAndProcessPayment);
        assertThrows(IllegalArgumentException.class, payment3::validateAndProcessPayment);
    }

    @Test
    @DisplayName("Receiver balance must be equals as defined in assertEquals")
    void validatePaymentValueAfterProcess(){
        Payment payment1 = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10", BigDecimal.TEN)
                .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                .withValue(new BigDecimal(4))
                .create();

        payment1.validateAndProcessPayment();
        BigDecimal receiverValue = payment1.getReceiver().getAccountBalance().getValue();
        BigDecimal payerValue = payment1.getPayer().getAccountBalance().getValue();
        assertEquals(new BigDecimal(14), receiverValue);
        assertEquals(new BigDecimal(6), payerValue);
    }

    @Test
    @DisplayName("Payment Status must be equals as defined in assertEquals")
    void validateDoProcessPaymentWithValidValues(){
        Payment payment1 = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10", BigDecimal.TEN)
                .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                .withValue(new BigDecimal(4))
                .create();
        payment1.doProcessPayment();
        assertEquals(PaymentStatus.PAYMENT_OK, payment1.getStatus());

        Payment payment2 = PaymentBuilder
                .build()
                .withPayer("Erick Lara", "123.456.789-10", null)
                .withReceiver("Graziela Lucena", "321.456.987-10", BigDecimal.TEN)
                .withValue(new BigDecimal(60))
                .create();
        payment2.doProcessPayment();
        assertEquals(PaymentStatus.PROCESS_FAILED, payment2.getStatus());
    }
}