package controller;

import dao.StudentDAO;
import model.Classroom;
import model.Student;
import service.ClassroomService;
import service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentServiceImpl studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(req, resp);
                break;
            case "edit":
                editForm(req,resp);
                break;
            case "delete":
                deleteForm(req,resp);
            default:
                showList(req, resp);
                break;
        }
    }

    private void deleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.findById(id);
        req.setAttribute("student", student);
        req.setAttribute("classrooms", ClassroomService.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/delete.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.findById(id);
        req.setAttribute("student", student);
        req.setAttribute("classrooms", ClassroomService.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/edit.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("classrooms", ClassroomService.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("studentList", studentService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/display.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addStudent(req,resp);
                break;
            case "edit":
                editStudent(req,resp);
                break;
            case "delete":
                deleteStudent(req,resp);
                break;
            case "search":
                searchStudent(req,resp);
                break;
            default:
                break;
        }
    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("search");
        List<Student> studentList = studentService.search(searchName);
        req.setAttribute("studentList", studentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/search.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.delete(id);
        try {
            resp.sendRedirect("/students");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        int idClassroom = Integer.parseInt(req.getParameter("idClassroom"));

        Student student = new Student(id, name, dateOfBirth, address, phoneNumber, email, idClassroom);
        studentService.edit(student, id);
        try {
            resp.sendRedirect("/students");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        int idClassroom = Integer.parseInt(req.getParameter("idClassroom"));
        Student student = new Student(name, dateOfBirth, address, phoneNumber, email, idClassroom);
        studentService.add(student);
        try {
            resp.sendRedirect("/students");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
