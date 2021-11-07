package br.com.cleanarch.school.application.aluno;

import br.com.cleanarch.school.domain.student.CPF;
import br.com.cleanarch.school.domain.student.Email;
import br.com.cleanarch.school.domain.student.Student;

public class RegisterStudentDto {
    private String studentName;
    private String studentCpf;
    private String studentEmail;

    public RegisterStudentDto(String studentName, String studentCpf, String studentEmail) {
        this.studentName = studentName;
        this.studentCpf = studentCpf;
        this.studentEmail = studentEmail;
    }

    public Student createStudent() {
        return new Student(new CPF(studentCpf), studentName, new Email(studentEmail));
    }
}
