package br.com.cleanarch.school.academic.infrastructure.indicacao;

import br.com.cleanarch.school.academic.application.indicacao.SendReferenceEmail;
import br.com.cleanarch.school.academic.domain.student.Student;

public class SendReferenceEmailWithJavaMail implements SendReferenceEmail {
    @Override
    public void sendTo(Student reffered) {
        // lógica com envio de email com a lib JavaMail.
        System.out.println("sending email...");
    }
}
