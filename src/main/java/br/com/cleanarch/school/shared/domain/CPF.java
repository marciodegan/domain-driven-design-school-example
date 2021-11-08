package br.com.cleanarch.school.shared.domain;

import br.com.cleanarch.school.academic.domain.student.CPFNotValid;

public class CPF {

    private String number;

    public CPF(String number) {
        if (number == null || !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new CPFNotValid(number);
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
