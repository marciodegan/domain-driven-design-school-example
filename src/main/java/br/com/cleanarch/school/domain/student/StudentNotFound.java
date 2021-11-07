package br.com.cleanarch.school.domain.student;

import br.com.cleanarch.school.domain.student.CPF;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(CPF cpf) {
        super("Student not found with CPF: " + cpf.getNumber());
    }
}
