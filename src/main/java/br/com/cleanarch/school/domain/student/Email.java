package br.com.cleanarch.school.domain.student;

public class Email {

    // VALUE OBJECT -

    private String email;

    public Email(String email) {
        if (email == null ||
                !email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
            this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
