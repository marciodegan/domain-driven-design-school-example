package br.com.cleanarch.school;

import br.com.cleanarch.school.academic.application.student.RegisterStudent;
import br.com.cleanarch.school.academic.application.student.RegisterStudentDto;
import br.com.cleanarch.school.gamification.application.GeraSeloAlunoNovato;
import br.com.cleanarch.school.gamification.infrastructure.selo.SeloRepositoryInMemory;
import br.com.cleanarch.school.shared.domain.evento.PublicadorDeEventos;
import br.com.cleanarch.school.shared.domain.CPF;
import br.com.cleanarch.school.academic.domain.student.Email;
import br.com.cleanarch.school.academic.domain.student.StudentRegisteredLog;
import br.com.cleanarch.school.academic.infrastructure.student.StudentRepositoryInMemory;
import br.com.cleanarch.school.academic.domain.student.Student;

/*
* Essa classe representa o ponto de entrada da aplicação. Poderia ser um módulo ou uma aplicação separada.
* Não tem problema em acessar múltiplos contextos, pois é a utilização de fato da aplicação.
* */
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


        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new StudentRegisteredLog());
        publicador.adicionar(new GeraSeloAlunoNovato(new SeloRepositoryInMemory()));
        RegisterStudent register = new RegisterStudent(new StudentRepositoryInMemory(), publicador);
        register.execute(new RegisterStudentDto(name, cpf.getNumber(), email.getEmail()));
//        register.toString();



    }
}
