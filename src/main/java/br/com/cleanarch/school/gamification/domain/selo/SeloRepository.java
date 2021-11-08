package br.com.cleanarch.school.gamification.domain.selo;

import br.com.cleanarch.school.gamification.domain.selo.Selo;
import br.com.cleanarch.school.academic.domain.student.CPF;

import java.util.List;

public interface SeloRepository {

    void add(Selo selo);
    List<Selo> selosDoStudentPorCpf(CPF cpf);
}
