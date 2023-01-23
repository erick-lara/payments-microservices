package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payment.PaymentStatus;

import java.math.BigDecimal;

public class AccountBalance {

    private BigDecimal accountBalance;
    private Payment payment;

    public AccountBalance(BigDecimal accountBalance, Payment payment) {
        this.accountBalance = accountBalance;
        this.payment = payment;
    }

    protected void validatePayment() {
        if(accountBalance == null){
            throw new IllegalArgumentException("Account balance must not be null");
        }

        if(payment.getPaymentValue().intValue() > this.getAccountBalance().intValue()){
            throw new ArithmeticException("Insufficient funds.");
        }

        this.accountBalance = this.accountBalance.subtract(payment.getPaymentValue());
        this.payment.setStatus(PaymentStatus.PAYMENT_OK);
    }

    public void setPaymentStatus(){
        try{
            this.validatePayment();
        } catch (ArithmeticException exception) {
            this.payment.setStatus(PaymentStatus.PROCESS_FAILED);
        }
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
