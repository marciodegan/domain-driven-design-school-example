package br.com.cleanarch.school;

import br.com.cleanarch.school.application.aluno.RegisterStudent;
import br.com.cleanarch.school.application.aluno.RegisterStudentDto;
import br.com.cleanarch.school.infrastructure.student.StudentRepositoryInMemory;

public class StudentRegistration {

    public static void main(String[] args) {
    /*
        String nome = "Fulano da Silva";
        CPF cpf = new CPF("123.456.749-00");
        Email email = new Email("fulno@email.com");

        Student student = new Student(cpf, nome, email);

        StudentRepository repository = new StudentRepositoryInMemory();
        repository.register(student);
    */

        String name = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@teste.com";

        RegisterStudent register = new RegisterStudent(new StudentRepositoryInMemory());
        register.execute(new RegisterStudentDto(name, cpf, email));

    }
}
