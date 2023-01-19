package br.com.erick.lara.payments.domain.payer;

public class PayerBuilder {
    private String name;
    private CPF cpf;


    public static PayerBuilder build(){
        return new PayerBuilder();
    }

    public PayerBuilder withName(String name){
        this.name = name;
        return this;
    }

    public PayerBuilder withCpf(String cpf){
        this.cpf = new CPF(cpf);
        return this;
    }

    public Payer create(){
        return new Payer(this.name, this.cpf);
    }
}
