package br.com.cleanarch.school.gamification.infrastructure.selo;

import br.com.cleanarch.school.gamification.domain.selo.SeloRepository;
import br.com.cleanarch.school.gamification.domain.selo.Selo;
import br.com.cleanarch.school.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeloRepositoryInMemory implements SeloRepository {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void add(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoStudentPorCpf(CPF cpf) {
        return this.selos
                .stream()
                .filter(s -> s.getStudentCPF().equals(cpf))
                .collect(Collectors.toList());
    }
}
