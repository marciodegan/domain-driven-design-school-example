package br.com.cleanarch.school.domain.reference;

import br.com.cleanarch.school.domain.student.CPF;
import br.com.cleanarch.school.domain.student.Email;
import br.com.cleanarch.school.domain.student.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceTest {

    @Test
    void shouldCreateAReference() {
        Student referrer = new Student(new CPF("123.456.789-00"), "João da Silva", new Email("joao@teste.com"));
        Student referred = new Student(new CPF("111.222.333-44"), "Maria da Silva", new Email("maria@teste.com"));

        Reference reference = new Reference(referred, referrer);
        assertEquals(reference.getReferrer(), referrer);
        assertEquals(reference.getReffered(), referred);
        assertNotNull(reference.getReferenceDate());

    }

}