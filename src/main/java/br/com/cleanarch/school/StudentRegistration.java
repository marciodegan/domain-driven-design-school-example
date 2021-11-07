package br.com.cleanarch.school;

import br.com.cleanarch.school.application.aluno.RegisterStudent;
import br.com.cleanarch.school.application.aluno.RegisterStudentDto;
import br.com.cleanarch.school.domain.student.CPF;
import br.com.cleanarch.school.domain.student.Email;
import br.com.cleanarch.school.domain.student.Student;
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
        CPF cpf = new CPF("123.456.789-00");
        Email email = new Email("fulano@teste.com");


//      === ADDING 2 PHONES ===
        Student student = new Student(cpf, name, email);
        student.addPhone("51", "12121212");
        student.addPhone("51", "99889977");

//      === MORE THAN 2 PHONES SHOULD THROWS EXCEPTION ===
//        student.addPhone("51", "30303030");


        RegisterStudent register = new RegisterStudent(new StudentRepositoryInMemory());
//        register.execute(new RegisterStudentDto(name, , email));
//        register.toString();



    }
}
