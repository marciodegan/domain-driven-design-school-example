package br.com.cleanarch.school.academic.domain.student;

import br.com.cleanarch.school.shared.domain.CPF;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(CPF cpf) {
        super("Student not found with CPF: " + cpf.getNumber());
    }
}
