package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payer.Payer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private long paymentId;
    private Value paymentValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private Payer payer;

    public Payment(long paymentId, Value paymentValue, Payer payer) {
        this.paymentId = paymentId;
        this.paymentValue = paymentValue;
        this.paymentDate = LocalDate.now();
        this.payer = payer;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue.totalValue();
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Payer getPayer() {
        return payer;
    }
}
