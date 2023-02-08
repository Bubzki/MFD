package bubzki.mdf.servlet;

import bubzki.mdf.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@WebServlet(name = "StudentAdd", value = "/studentAdd")
public class StudentAdd extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Student> students = (List<Student>) session.getAttribute("students");
        if (students == null) {
            students = new LinkedList<>();
            session.setAttribute("students", students);
        }
        if (request.getParameter("name") != "" || request.getParameter("surname") != "") {
            Student student = new Student(request.getParameter("name"),
                    request.getParameter("surname"),
                    request.getParameter("age"),
                    request.getParameter("email"),
                    request.getParameter("group"),
                    request.getParameter("faculty"));
            students.add(student);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
        //response.sendRedirect("index.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
