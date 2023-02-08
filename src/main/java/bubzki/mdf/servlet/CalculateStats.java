package bubzki.mdf.servlet;

import bubzki.mdf.entity.StatsCalculator;
import bubzki.mdf.entity.Student;
import bubzki.mdf.util.Utils;
import bubzki.mdf.exception.AgeException;
import bubzki.mdf.exception.EmailException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CalculateStats", value = "/calculateStats")
public class CalculateStats extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Student> students = (List<Student>) session.getAttribute("students");
        StatsCalculator stat = StatsCalculator.getInstance();
        try {
            stat.setYoungestStudent(Utils.calculateYoungestStudent((LinkedList<Student>) students));
        } catch (AgeException e) {
            System.out.printf(e.getMessage());
            e.printStackTrace();
        }
        try {
            stat.setOldestStudent(Utils.calculateOldestStudent((LinkedList<Student>) students));
        } catch (AgeException e) {
            System.out.printf(e.getMessage());
            e.printStackTrace();
        }
        try {
            stat.setAverageAge(Utils.calculateAverageAge((LinkedList<Student>) students));
        } catch (AgeException e) {
            System.out.printf(e.getMessage());
            e.printStackTrace();
        }
        try {
            stat.setPopularDomain(Utils.calculatePopularDomain((LinkedList<Student>) students));
        } catch (EmailException e) {
            System.out.printf(e.getMessage());
            e.printStackTrace();
        }
        try {
            stat.setSumduDomain(Utils.calculateSumduDomain((LinkedList<Student>) students));
        } catch (EmailException e) {
            System.out.printf(e.getMessage());
            e.printStackTrace();
        }
        stat.setGroups(Utils.calculateGroups((LinkedList<Student>) students));
        stat.setFaculties(Utils.calculateStudentsFromFaculty((LinkedList<Student>) students));
        session.setAttribute("stat", stat);
        /*for(Map.Entry<String, Integer> temp : stat.getFaculties().entrySet()) {
            temp.getKey(); temp.getValue();

        }*/
        request.getRequestDispatcher("statistic.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
}
