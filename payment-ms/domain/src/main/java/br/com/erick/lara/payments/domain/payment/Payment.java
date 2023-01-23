package br.com.erick.lara.payments.domain.payment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Payment {

    private final Value paymentValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate paymentDate;
    private final User payer;
    private final User receiver;
    private PaymentStatus status;

    public Payment(Value paymentValue, User payer, User receiver) {
        this.paymentValue = paymentValue;
        this.paymentDate = LocalDate.now();
        this.payer = payer;
        this.receiver = receiver;
        this.status = PaymentStatus.PROCESSING_PAYMENT;
    }

    protected void validateAndProcessPayment() {
        if(payer.getAccountBalance().getValue() == null){
            throw new IllegalArgumentException("Account balance must not be null");
        }

        this.processPayment();
    }

    private void processPayment(){
        this.payer.getAccountBalance().subtractBalance(this.paymentValue.totalValue());
        this.status = PaymentStatus.PAYMENT_OK;
        this.receiver.getAccountBalance().addBalance(this.paymentValue.totalValue());
    }

    public void doProcessPayment(){
        try {
            this.validateAndProcessPayment();
        } catch (ArithmeticException | IllegalArgumentException exception) {
            this.status = PaymentStatus.PROCESS_FAILED;
        }
    }


    public PaymentStatus getStatus() {
        return status;
    }

    public User getPayer() {
        return payer;
    }

    public User getReceiver() {
        return receiver;
    }
}
