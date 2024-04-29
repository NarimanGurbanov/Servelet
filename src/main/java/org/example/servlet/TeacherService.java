package com.example.educationsystemwebabb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/education";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abcdef123";


    public void insertTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher(name,surname,age,salary) VALUES (?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql) ) {


                statement.setString(1, teacher.getFirstName());
                statement.setString(2, teacher.getLastName());
                statement.setInt(3, teacher.getAge());
                statement.setDouble(4, teacher.getSalary());

                statement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Error occurred while inserting teacher: " + e.getMessage());
        }
    }


    public Teacher findById(Integer id) {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    teacher = new Teacher();
                    teacher.setId(resultSet.getInt("id"));
                    teacher.setFirstName(resultSet.getString("name"));
                    teacher.setLastName(resultSet.getString("surname"));
                    teacher.setAge(resultSet.getInt("age"));
                    teacher.setSalary(resultSet.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error occurred while finding teacher by ID: " + e.getMessage());
        }

        return teacher;
    }


    public void updateTeacher(Teacher teacher) {
        String sql = "UPDATE teacher SET name=?, surname=?, age=?, salary=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setInt(3, teacher.getAge());
            statement.setDouble(4, teacher.getSalary());
            statement.setInt(5, teacher.getId());

            statement.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Error occurred while updating teacher: " + e.getMessage());
        }
    }

    public void deleteTeacher(Integer choose) {
        String sql = "DELETE FROM teacher WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, choose);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error occurred while delete  teacher: " + e.getMessage());
        }
    }

    public List<Teacher> findTeacher(String name, String surname) {
        List<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT * FROM teacher WHERE name LIKE ?";

        boolean hasSurname = surname != null && !surname.isEmpty();

        if (hasSurname) {
            sql += " OR surname LIKE ?";
        }

        try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + name + "%");
            if (hasSurname) {
                statement.setString(2, "%" + surname + "%");
            }

            try (ResultSet resultSet = statement.executeQuery()){

                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(resultSet.getInt("id"));
                    teacher.setFirstName(resultSet.getString("name"));
                    teacher.setLastName(resultSet.getString("surname"));
                    teacher.setAge(resultSet.getInt("age"));
                    teacher.setSalary(resultSet.getDouble("salary"));
                    teachers.add(teacher);

                }

            }

        } catch (SQLException e) {
            System.err.println("Error occurred while delete  teacher: " + e.getMessage());
        }
        return teachers;
    }


    public List<Teacher> printAll() {

        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT id,name,surname,age,salary FROM teacher";
        try (Connection connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setFirstName(resultSet.getString("name"));
                teacher.setLastName(resultSet.getString("surname"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setSalary(resultSet.getDouble("salary"));
                teachers.add(teacher);

            }

            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
