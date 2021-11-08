package br.com.cleanarch.school.academic.infrastructure.student;

import br.com.cleanarch.school.academic.domain.student.CPF;
import br.com.cleanarch.school.academic.domain.StudentRepository;
import br.com.cleanarch.school.academic.domain.student.Student;
import br.com.cleanarch.school.academic.domain.student.StudentNotFound;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> registered = new ArrayList<>();

    @Override
    public void register(Student student) {
        this.registered.add(student);
    }

    @Override
    public Student findByCpf(CPF cpf) {
        return this.registered.stream()
                .filter(s -> s.getCpf().getNumber().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> listAllRegisteredStudents() {
        return this.registered;
    }
}
