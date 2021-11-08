package br.com.cleanarch.school.academic.domain.student;

import br.com.cleanarch.school.shared.domain.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void beforeEach() {
        student = new Student(new CPF("123.456.789-00"), "Fulano", new Email("fulano@teste.com"));
    }

    @Test
    void shouldAddOnePhoneNumber() {
        student.addPhone("11", "11112222");
        assertEquals(1, student.getPhones().size());
    }

    @Test
    void shouldAddTwoPhoneNumbers() {
        student.addPhone("11", "11112222");
        student.addPhone("22", "22223333");
        assertEquals(2, student.getPhones().size());
    }

    @Test
    void shouldThrowExceptionNotAllowedMoreThanTwoNumber() {
        assertThrows(MaxPhoneNumberReached.class,
                () -> {
                    student.addPhone("11", "11112222");
                    student.addPhone("22", "22223333");
                    student.addPhone("33", "33333333");
                });
    }

}