package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payer.UserBuilder;

import java.math.BigDecimal;

public class PaymentBuilder {
    private Value value;
    private User payer;
    private User receiver;

    public static PaymentBuilder build(){
        return new PaymentBuilder();
    }

    public PaymentBuilder withValue(BigDecimal value){
        this.value = new Value(value);
        return this;
    }

    public PaymentBuilder withPayer(String name, String cpf, BigDecimal accountBalance){
        this.payer = UserBuilder
                .build()
                .withName(name)
                .withCpf(cpf)
                .withAccountBalance(accountBalance)
                .create();

        return this;
    }

    public PaymentBuilder withReceiver(String name, String cpf, BigDecimal accountBalance){
        this.receiver = UserBuilder
                .build()
                .withName(name)
                .withCpf(cpf)
                .withAccountBalance(accountBalance)
                .create();

        return this;
    }


    public Payment create(){
        return new Payment(this.value, this.payer, this.receiver);
    }
}
