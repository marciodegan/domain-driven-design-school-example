package br.com.cleanarch.school.domain.student;

public class Phone {

    private String ddd;
    private String number;

    public Phone(String ddd, String number) {
        if (ddd == null || number == null) {
            throw new IllegalArgumentException("DDD and Phone Number can´t be null");
        }
        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("Invalid DDD Number");
        }
        if (!number.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}
