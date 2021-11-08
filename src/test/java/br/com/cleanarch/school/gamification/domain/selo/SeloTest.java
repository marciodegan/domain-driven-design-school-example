package br.com.cleanarch.school.gamification.domain.selo;

import br.com.cleanarch.school.academic.domain.student.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeloTest {

    @Test
    void shouldCreateASelo() {
        CPF cpf = new CPF("333.333.333-00");
        String name = "course certification XPTO";
        Selo selo = new Selo(cpf, name);
        assertEquals(selo.getStudentCPF(), cpf);
        assertEquals(selo.getName(), name);

    }

}