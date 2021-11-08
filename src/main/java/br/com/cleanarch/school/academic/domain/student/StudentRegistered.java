package br.com.cleanarch.school.academic.domain.student;

import br.com.cleanarch.school.shared.domain.evento.Evento;
import br.com.cleanarch.school.shared.domain.CPF;
import br.com.cleanarch.school.shared.domain.evento.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", studentCPF);
    }

    public CPF getStudentCPF() {
        return studentCPF;
    }
}