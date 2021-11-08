package br.com.cleanarch.school.academic.domain.student;

public class CPFNotValid extends RuntimeException {
    public CPFNotValid(String cpf) {
        super("CPF not valid");
    }

}
