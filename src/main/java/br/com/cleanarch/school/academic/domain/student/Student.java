package br.com.cleanarch.school.academic.domain.student;

import br.com.cleanarch.school.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;

public class Student {

    // ENTITY
    // AGGREGATE ROOT

    private CPF cpf;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    private String senha;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(String ddd, String number) {
        if (phones.size() == 2) {
            throw new MaxPhoneNumberReached(new Phone(ddd, number));
        }
        this.phones.add(new Phone(ddd, number));
        System.out.println("Adding phone (" + ddd + ")" + number + " for student: " + name);
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
