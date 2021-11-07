package br.com.cleanarch.school.infrastructure.student;

import br.com.cleanarch.school.domain.StudentRepository;
import br.com.cleanarch.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcRepository implements StudentRepository {

    private final Connection connection;

    public StudentJdbcRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Student student) {
        try {
            String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO PHONE VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            for (Phone phone : student.getPhones()) {
                ps.setString(1, phone.getDdd());
                ps.setString(2, phone.getNumber());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student findByCpf(CPF cpf) {
        try {
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            if (!found) {
                throw new StudentNotFound(cpf);
            }
            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student foundStudent = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                foundStudent.addPhone(ddd, number);
            }
            return foundStudent;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAllRegisteredStudents() {
        try {
            String sql = "SELECT id, cpf, name, email FROM STUDENT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, name, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();
                while (rsPhone.next()) {
                    String number = rsPhone.getString("number");
                    String ddd = rsPhone.getString("ddd");
                    student.addPhone(ddd, number);
                }
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
