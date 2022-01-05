package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class StudentDAO {
    private static Connection connection = ConnectMySql.getConnection();

    private static final String SELECT_ALL_STUDENTS = "SELECT student.*, classroom.name as classname FROM student join classroom on student.idclassroom = classroom.id;";
    private static final String INSERT_STUDENT = "INSERT INTO student (`name`, `datofbirth`, `address`, `phonenumber`, `email`,`idclassroom`) VALUES (?,?,?,?,?,?);";
    private static final String FIND_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    private static final String EDIT_STUDENT = "UPDATE student SET name = ?, datofbirth = ?, address= ?,phonenumber=?,email=?, idclassroom=? WHERE id =? ";
    private static final String DELETE_STUDENT = "DELETE from student where id=?";
    private static final String SEARCH_STUDENT = "SELECT student.*, classroom.name as classname FROM student join classroom on student.idclassroom = classroom.id WHERE student.name LIKE ?";

    public static List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("datofbirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                int idClassroom = resultSet.getInt("idclassroom");
                String className = resultSet.getString("classname");

                studentList.add(new Student(id, name, dateOfBirth, address, phoneNumber, email, className, idClassroom));
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDateOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getIdClassroom());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Student findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id2 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("datofbirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                int idClassroom = resultSet.getInt("idclassroom");
                return new Student(id2, name, dateOfBirth, address, phoneNumber, email, idClassroom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void editStudent(Student student, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDateOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getIdClassroom());
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> searchStudent(String searchName) {
        ArrayList<Student> searchList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT);
            preparedStatement.setString(1, "%" + searchName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("datofbirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String className = resultSet.getString("classname");
                int idClassroom = resultSet.getInt("idclassroom");

                searchList.add(new Student(id, name, dateOfBirth, address, phoneNumber, email, className, idClassroom));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchList;
    }
}
