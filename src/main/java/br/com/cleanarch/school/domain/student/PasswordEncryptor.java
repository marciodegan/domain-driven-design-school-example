package br.com.cleanarch.school.domain.student;

public interface PasswordEncryptor {

/*
     This interface is on the domain module, representing the "service" for password encryption.
     But how the password is going to be encrypted (the implementation) should be at infrastructure module.
*/

    String encryptPassword(String password);

    boolean validateEncryptedPassword(String encryptedPassword, String password);

}
