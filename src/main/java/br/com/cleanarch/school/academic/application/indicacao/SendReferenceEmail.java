package br.com.cleanarch.school.academic.application.indicacao;

import br.com.cleanarch.school.academic.domain.student.Student;

public interface SendReferenceEmail {

    void sendTo(Student reffered);

}
