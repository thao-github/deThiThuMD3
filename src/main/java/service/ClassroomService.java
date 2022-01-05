package service;

import dao.ClassroomDAO;
import model.Classroom;

import java.util.List;

public class ClassroomService {
    public static List<Classroom> getAll(){
        return ClassroomDAO.getAllClassroom();
    }
}
