package br.com.cleanarch.school.application.aluno;

import br.com.cleanarch.school.domain.StudentRepository;
import br.com.cleanarch.school.domain.student.Student;

public class RegisterStudent {

    private final StudentRepository repository;

    public RegisterStudent(StudentRepository repository) {
        this.repository = repository;
    }

    // COMMAND PATTERN - p/  executar uma ação
    public void execute(RegisterStudentDto data) {
        Student newStudent = data.createStudent();
        repository.register(newStudent);
    }
}
