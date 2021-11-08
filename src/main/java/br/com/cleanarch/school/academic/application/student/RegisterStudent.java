package br.com.cleanarch.school.academic.application.student;

import br.com.cleanarch.school.academic.domain.PublicadorDeEventos;
import br.com.cleanarch.school.academic.domain.StudentRepository;
import br.com.cleanarch.school.academic.domain.student.StudentRegistered;
import br.com.cleanarch.school.academic.domain.student.Student;


public class RegisterStudent {

    private final StudentRepository repository;
    private final PublicadorDeEventos publicador;

    public RegisterStudent(StudentRepository repository, PublicadorDeEventos publicador) {
        this.repository = repository;
        this.publicador = publicador;
    }

    // COMMAND PATTERN - p/  executar uma ação
    public void execute(RegisterStudentDto data) {
        Student newStudent = data.createStudent();
        repository.register(newStudent);

        StudentRegistered evento = new StudentRegistered(newStudent.getCpf());
        publicador.publicar(evento);
    }
}
