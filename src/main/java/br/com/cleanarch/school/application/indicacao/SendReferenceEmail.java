package br.com.cleanarch.school.application.indicacao;

import br.com.cleanarch.school.domain.student.Student;

public interface SendReferenceEmail {

    void sendTo(Student reffered);

}
