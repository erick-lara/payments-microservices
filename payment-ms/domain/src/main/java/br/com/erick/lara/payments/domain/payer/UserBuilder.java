package br.com.erick.lara.payments.domain.payer;

import br.com.erick.lara.payments.domain.payment.AccountBalance;
import br.com.erick.lara.payments.domain.payment.User;

import java.math.BigDecimal;

public class UserBuilder {

    private String name;
    private CPF cpf;
    private AccountBalance accountBalance;

    public static UserBuilder build(){
        return new UserBuilder();
    }

    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder withCpf(String cpf){
        this.cpf = new CPF(cpf);
        return this;
    }

    public UserBuilder withAccountBalance(BigDecimal balance){
        this.accountBalance = new AccountBalance(balance);
        return this;
    }

    public User create(){
        return new User(this.name, this.cpf, this.accountBalance);
    }
}
