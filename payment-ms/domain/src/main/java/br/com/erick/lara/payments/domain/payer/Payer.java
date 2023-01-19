package br.com.erick.lara.payments.domain.payer;

public class Payer {

    private String name;
    private CPF cpf;

    public Payer(String name, CPF cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf.toString();
    }

    public String getName() {
        return name;
    }
}
