package br.com.cleanarch.school.academic.domain.student;

public class MaxPhoneNumberReached extends RuntimeException {
    public MaxPhoneNumberReached (Phone phone) {
        super("Max phone number reached. The number '(" + phone.getDdd() + ")" + phone.getNumber() + "' was not added.");
    }

}
