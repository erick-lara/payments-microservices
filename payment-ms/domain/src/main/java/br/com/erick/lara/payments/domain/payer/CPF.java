package br.com.erick.lara.payments.domain.payer;

public class CPF {
    private final String documentValue;

    public CPF(String documentValue) {
        if(isCpfInvalid(documentValue)){
            throw new IllegalArgumentException("Invalid CPF for Client.");
        }
        this.documentValue = documentValue;
    }

    private boolean isCpfInvalid(String cpf){
        return cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
    }

    @Override
    public String toString() {
        return documentValue;
    }
}
