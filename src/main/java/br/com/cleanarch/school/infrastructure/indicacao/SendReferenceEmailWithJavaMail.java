package br.com.cleanarch.school.infrastructure.indicacao;

import br.com.cleanarch.school.application.indicacao.SendReferenceEmail;
import br.com.cleanarch.school.domain.student.Student;

public class SendReferenceEmailWithJavaMail implements SendReferenceEmail {
    @Override
    public void sendTo(Student reffered) {
        // lógica com envio de email com a lib JavaMail.
        System.out.println("sending email...");
    }
}
