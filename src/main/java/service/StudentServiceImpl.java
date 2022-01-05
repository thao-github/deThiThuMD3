package service;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements IStudent {
    private static List<Student> studentList = StudentDAO.getAllStudent();

    @Override
    public List<Student> findAll() {
        studentList = StudentDAO.getAllStudent();
        return studentList;
    }

    @Override
    public void add(Student student) {
        StudentDAO.addStudent(student);
        studentList = StudentDAO.getAllStudent();
    }

    @Override
    public Student findById(int id) {
        return StudentDAO.findById(id);
    }

    @Override
    public void edit(Student student, int id) {
        StudentDAO.editStudent(student, id);
    }

    @Override
    public void delete(int id) {
        StudentDAO.deleteStudent(id);
    }

    @Override
    public List<Student> search(String name) {
        return StudentDAO.searchStudent(name);
    }
}
