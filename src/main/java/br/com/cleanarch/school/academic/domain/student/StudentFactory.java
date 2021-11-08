package br.com.cleanarch.school.academic.domain.student;

import br.com.cleanarch.school.shared.domain.CPF;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCpfEmail(String name, String cpf, String email){
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public StudentFactory withPhone(String ddd, String number) {
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create(){
        return this.student;
    }
}
