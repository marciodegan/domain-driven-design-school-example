package br.com.cleanarch.school.cleanarch.school;

import br.com.cleanarch.school.domain.student.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void shouldNotCreateCpfWithInvalidNumber(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("123456789"));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));

    }

    @Test
    void shouldCreateCpfWithValidNumber() {
        String number = "123.456.789-00";
        CPF cpf = new CPF(number);
        assertEquals(cpf.getNumber(), number);
    }

}