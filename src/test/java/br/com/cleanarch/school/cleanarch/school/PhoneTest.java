package br.com.cleanarch.school.cleanarch.school;

import br.com.cleanarch.school.domain.student.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldNotCreatePhoneWithInvalidDDD() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", "12345678"));
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null, "123456789"));
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("1222", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneWithInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("12", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("12", ""));
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("12", "323"));
    }

    @Test
    void shouldCreatePhoneWithValidDddAndPhoneNumber(){
        String ddd = "11";
        String number = "12345678";
        Phone phone = new Phone(ddd, number);
        assertEquals(ddd, phone.getDdd());
        assertEquals(number, phone.getNumber());
    }

}