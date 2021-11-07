package br.com.cleanarch.school.domain.student;

public class CPFNotValid extends RuntimeException {
    public CPFNotValid(String cpf) {
        super("CPF not valid");
    }

}
