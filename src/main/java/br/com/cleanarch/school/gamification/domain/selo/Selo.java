package br.com.cleanarch.school.gamification.domain.selo;

import br.com.cleanarch.school.shared.domain.CPF;

/*
    Gamificação. Toda vez que o Student completar algo, ganha um selo.
*/

public class Selo {

    private CPF studentCPF;
    private String name;

    public Selo(CPF studentCPF, String name) {
        this.studentCPF = studentCPF;
        this.name = name;
    }

    public CPF getStudentCPF() {
        return studentCPF;
    }

    public String getName() {
        return name;
    }
}
