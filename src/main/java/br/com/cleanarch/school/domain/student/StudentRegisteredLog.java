package br.com.cleanarch.school.domain.student;

import br.com.cleanarch.school.domain.Evento;
import br.com.cleanarch.school.domain.Ouvinte;

import java.time.format.DateTimeFormatter;

/*
Essa classe representa um dos ouvintes do evento de Aluno Matriculado.
Quando ela for chamada, ela vai estar ouvindo o Aluno Matriculado e seu trabalho é gerar um log.
Um ouvinte não está amarrado com outro. Então se precisar cadastrar novo ouvinte ou mudar, este não muda nada.
O código fica mais fácil de manter, de extender e de adicionar novos comportamentos.
*/
public class StudentRegisteredLog extends Ouvinte {

    public void reageAo(Evento evento) {

        String momentoFormatted = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(String.format(
                "Student with CPF %s registered in: %s",
                ((StudentRegistered) evento).getStudentCPF(),
                momentoFormatted
        ));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof StudentRegistered;
    }
}