package br.com.cleanarch.school.academic.domain.student;

import br.com.cleanarch.school.academic.domain.student.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotCreateEmailsWithInvalidAddresses(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("invalidemail.com"));
    }

    @Test
    void shouldCreateEmailWithValidAddress() {
        String address = "marcio@me.com";
        Email email = new Email(address);
        assertEquals(email.getEmail(), address);
    }



}