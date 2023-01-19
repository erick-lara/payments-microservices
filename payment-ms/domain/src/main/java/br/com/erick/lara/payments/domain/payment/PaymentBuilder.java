package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payer.Payer;
import br.com.erick.lara.payments.domain.payer.PayerBuilder;

import java.math.BigDecimal;

public class PaymentBuilder {
    private long paymentId;
    private Value value;
    private Payer payer;

    public static PaymentBuilder build(){
        return new PaymentBuilder();
    }

    public PaymentBuilder withValue(BigDecimal value){
        this.value = new Value(value);
        return this;
    }

    public PaymentBuilder withId(long value){
        this.paymentId = value;
        return this;
    }

    public PaymentBuilder withPayer(String name, String cpf){
        this.payer = PayerBuilder
                .build()
                .withName(name)
                .withCpf(cpf)
                .create();

        return this;
    }


    public Payment create(){
        return new Payment(this.paymentId, this.value, this.payer);
    }
}
