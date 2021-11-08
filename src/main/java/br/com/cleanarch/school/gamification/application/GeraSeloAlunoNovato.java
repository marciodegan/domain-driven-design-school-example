package br.com.cleanarch.school.gamification.application;

import br.com.cleanarch.school.gamification.domain.selo.Selo;
import br.com.cleanarch.school.gamification.domain.selo.SeloRepository;
import br.com.cleanarch.school.shared.domain.CPF;
import br.com.cleanarch.school.shared.domain.evento.Evento;
import br.com.cleanarch.school.shared.domain.evento.Ouvinte;
import br.com.cleanarch.school.shared.domain.evento.TipoDeEvento;

/*
Essa classe é ouvinte. Precisa herdar da classe Ouvinte. Mas gera acoplamento ao contexto academico, então "evento" foi refatorado para contexto shared.
* */
public class GeraSeloAlunoNovato extends Ouvinte {

    private final SeloRepository repository;

    public GeraSeloAlunoNovato(SeloRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void reageAo(Evento evento) {
//        CPF cpfDoAluno = evento.informacoes().get("cpf");
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf"); // faz um cast para CPF. Estamos acessando info do CPF, mas do contexto shared e não academico.
        Selo novato = new Selo(cpfDoAluno, "Novato");
        repository.add(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
