package br.com.cleanarch.school.domain.reference;

import br.com.cleanarch.school.domain.student.Student;

import java.time.LocalDateTime;

public class Reference {

    private Student reffered;
    private Student referrer;
    private LocalDateTime referenceDate;

    public Reference(Student reffered, Student referrer) {
        this.reffered = reffered;
        this.referrer = referrer;
        this.referenceDate = LocalDateTime.now();
    }

    public Student getReffered() {
        return reffered;
    }

    public Student getReferrer() {
        return referrer;
    }

    public LocalDateTime getReferenceDate() {
        return referenceDate;
    }
}
