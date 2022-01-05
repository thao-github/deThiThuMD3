package dao;

import model.Classroom;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO {
    private static Connection connection = ConnectMySql.getConnection();

    public static List<Classroom> getAllClassroom() {
        String sqlGetAll = "SELECT * FROM classroom";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAll);

            List<Classroom> classrooms = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                classrooms.add(new Classroom(id, name));
            }
            return classrooms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
