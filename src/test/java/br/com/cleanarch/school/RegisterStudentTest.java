package br.com.cleanarch.school;

import br.com.cleanarch.school.application.aluno.RegisterStudent;
import br.com.cleanarch.school.application.aluno.RegisterStudentDto;
import br.com.cleanarch.school.domain.student.CPF;
import br.com.cleanarch.school.domain.student.Student;
import br.com.cleanarch.school.infrastructure.student.StudentRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterStudentTest {

    @Test
    void studentShouldBePersisted() {
        StudentRepositoryInMemory repository = new StudentRepositoryInMemory();
        RegisterStudent useCase = new RegisterStudent(repository);

        String name = "Fulano";
        String cpf = "123.456.789-99";
        String email = "fulano@teste.com";

        RegisterStudentDto dados = new RegisterStudentDto(name, cpf, email);
        useCase.execute(dados);

        Student found = repository.findByCpf(new CPF("123.456.789-99"));

        assertEquals(name, found.getName());
        assertEquals(cpf, found.getCpf());
        assertEquals(email, found.getEmail());

    }

}