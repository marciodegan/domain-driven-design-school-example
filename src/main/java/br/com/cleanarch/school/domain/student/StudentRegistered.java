package br.com.cleanarch.school.domain.student;

import br.com.cleanarch.school.domain.Evento;

import java.time.LocalDateTime;

public class StudentRegistered implements Evento {

    private final CPF studentCPF;
    private final LocalDateTime momento;

    /*
    Aqui poderia passar um objeto Student, ao invés de CPF, porém estaríamos expondo outros atributos e info do Student que não interessam aqui.
    Com o CPF já é possivel identificar o aluno. Se passássemos um objeto "Student", um "ouvinte" poderia, por exemplo, adicionar telefones.
    E talvez não queremos que isso seja permitido.
    */
    public StudentRegistered(CPF studentCPF) {
        this.studentCPF = studentCPF;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public CPF getStudentCPF() {
        return studentCPF;
    }
}