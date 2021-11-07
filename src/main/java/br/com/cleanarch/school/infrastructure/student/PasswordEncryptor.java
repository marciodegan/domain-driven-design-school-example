package br.com.cleanarch.school.infrastructure.student;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor implements br.com.cleanarch.school.domain.student.PasswordEncryptor {

    /*
    In case we need to change Encrypt service, we can only change here, but the domain interface stays unchanged.
    The new encryption class will implement "PasswordEncryptor interface" and nothing else needs to be changed.
    * */
    @Override
    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    // pegar a senha passada "password" cifrá-la e checkar se senha é igual a "encryptedPassword"
    @Override
    public boolean validateEncryptedPassword(String encryptedPassword, String password) {
        return encryptedPassword.equals(encryptPassword(password));
    }
}
