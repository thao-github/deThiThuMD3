package service;

import model.Student;

import java.util.List;

public interface IStudent {

    public List<Student> findAll();

    public void add(Student student);

    public Student findById(int id);

    public void edit (Student student, int id);

    public void delete (int id);

    public List<Student> search (String name);

}
