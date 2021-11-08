package br.com.cleanarch.school.academic.domain;

import br.com.cleanarch.school.academic.domain.student.CPF;
import br.com.cleanarch.school.academic.domain.student.Student;

import java.util.List;

public interface StudentRepository {

    void register(Student student);

    Student findByCpf(CPF cpf);

    List<Student> listAllRegisteredStudents();

}
