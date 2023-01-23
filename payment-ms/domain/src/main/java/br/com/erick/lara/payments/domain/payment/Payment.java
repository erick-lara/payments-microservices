package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payer.Payer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private Value paymentValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    private Payer payer;
    private PaymentStatus status;

    public Payment(Value paymentValue, Payer payer) {
        this.paymentValue = paymentValue;
        this.paymentDate = LocalDate.now();
        this.payer = payer;
        this.status = PaymentStatus.PROCESSING_PAYMENT;
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

    public PaymentStatus getStatus() {
        return status;
    }

    protected void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
