package br.com.cleanarch.school.academic.application.student;

import br.com.cleanarch.school.shared.domain.CPF;
import br.com.cleanarch.school.academic.domain.student.Email;
import br.com.cleanarch.school.academic.domain.student.Student;

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
