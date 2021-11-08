package br.com.cleanarch.school.academic.application.student;

import br.com.cleanarch.school.shared.domain.evento.PublicadorDeEventos;
import br.com.cleanarch.school.shared.domain.CPF;
import br.com.cleanarch.school.academic.infrastructure.student.StudentRepositoryInMemory;
import br.com.cleanarch.school.academic.domain.student.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterStudentTest {

    @Test
    void studentShouldBePersisted() {
        StudentRepositoryInMemory repository = new StudentRepositoryInMemory();
        PublicadorDeEventos publisher = new PublicadorDeEventos();
        RegisterStudent useCase = new RegisterStudent(repository, publisher);

        String name = "Fulano";
        String cpf = "123.456.789-99";
        String email = "fulano@teste.com";
        CPF cpf1 = new CPF("123.456.789-99");

        RegisterStudentDto dados = new RegisterStudentDto(name, cpf, email);
        useCase.execute(dados);

        Student found = repository.findByCpf(cpf1);

        assertEquals(name, found.getName());
        assertEquals(cpf, found.getCpf().getNumber());
        assertEquals(email, found.getEmail());

    }

}