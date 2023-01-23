package br.com.erick.lara.payments.domain.payment;

import br.com.erick.lara.payments.domain.payer.CPF;

public class User {

    private final String name;
    private final CPF cpf;
    private final AccountBalance accountBalance;

    public User(String name, CPF cpf, AccountBalance accountBalance) {
        this.name = name;
        this.cpf = cpf;
        this.accountBalance = accountBalance;
    }

    public String getCpf() {
        return cpf.toString();
    }

    public String getName() {
        return name;
    }

    public AccountBalance getAccountBalance() {
        return accountBalance;
    }
}
