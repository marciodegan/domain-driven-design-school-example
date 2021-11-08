package br.com.cleanarch.school.academic.domain.student;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(CPF cpf) {
        super("Student not found with CPF: " + cpf.getNumber());
    }
}
