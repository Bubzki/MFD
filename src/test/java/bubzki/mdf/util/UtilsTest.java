package bubzki.mdf.util;

import bubzki.mdf.entity.Student;
import bubzki.mdf.exception.AgeException;
import bubzki.mdf.exception.EmailException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {
    static LinkedList<Student> students;

    @BeforeAll
    static void setUp() {
        students = new LinkedList<>();
        students.add(new Student("Name1", "Surname1", "15",
                "test1@email.com", "group1", "faculty1"));
        students.add(new Student("Name2", "Surname2", "10",
                "test2@email.com", "group1", "faculty2"));
        students.add(new Student("Name3", "Surname3", "25",
                "test3@email.com", "group2", "faculty3"));
        students.add(new Student("Name4", "Surname4", "20",
                "test4@edu.sumdu.ua", "group3", "faculty3"));
        students.add(new Student("Name5", "Surname5", "60",
                "test5@sumdu.com", "group3", "faculty3"));
    }

    @Test
    void testExpectedAgeExceptionOnCalculateYoungestStudent() {
        students.add(new Student("Name6", "Surname6", "Eleven",
                "test1@gmail.com", "group1", "faculty1"));
        Assertions.assertThrows(AgeException.class, () -> {
            Utils.calculateYoungestStudent(students);
        });
        students.removeLast();
    }

    @Test
    void testExpectedAgeExceptionOnCalculateOldestStudent() {
        students.add(new Student("Name6", "Surname6", "Seventy",
                "test1@gmail.com", "group1", "faculty1"));
        Assertions.assertThrows(AgeException.class, () -> {
            Utils.calculateOldestStudent(students);
        });
        students.removeLast();
    }

    @Test
    void testExpectedAgeExceptionOnCalculateAverageAge() {
        students.add(new Student("Name6", "Surname6", "Twenty",
                "test1@gmail.com", "group1", "faculty1"));
        Assertions.assertThrows(AgeException.class, () -> {
            Utils.calculateAverageAge(students);
        });
        students.removeLast();
    }

    @Test
    void testExpectedAgeExceptionOnCalculatePopularDomain() {
        students.add(new Student("Name6", "Surname6", "16",
                "test1.com", "group1", "faculty1"));
        Assertions.assertThrows(EmailException.class, () -> {
            Utils.calculatePopularDomain(students);
        });
        students.removeLast();
    }

    @Test
    void testExpectedAgeExceptionOnCalculateSumduDomain() {
        students.add(new Student("Name6", "Surname6", "16",
                "test1.com", "group1", "faculty1"));
        Assertions.assertThrows(EmailException.class, () -> {
            Utils.calculateSumduDomain(students);
        });
        students.removeLast();
    }

    @Test
    void calculateYoungestStudent() throws AgeException {
        String result = Utils.calculateYoungestStudent(students);
        assertEquals("Name2 Surname2", result);
    }

    @Test
    void calculateOldestStudent() throws AgeException {
        String result = Utils.calculateOldestStudent(students);
        assertEquals("Name5 Surname5", result);
    }

    @Test
    void calculateAverageAge() throws AgeException {
        float result = Utils.calculateAverageAge(students);
        assertEquals(26, result);
    }

    @Test
    void calculatePopularDomain() throws EmailException {
        String result = Utils.calculatePopularDomain(students);
        assertEquals("email.com", result);
    }

    @Test
    void calculateSumduDomain() throws EmailException {
        int result = Utils.calculateSumduDomain(students);
        assertEquals(2, result);
    }

    @Test
    void calculateGroups() {
        int result = Utils.calculateGroups(students);
        assertEquals(3, result);
    }

    @Test
    void calculateStudentsFromFaculty() {
        Map<String, Integer> result = Utils.calculateStudentsFromFaculty(students);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("faculty1", 1);
        expected.put("faculty2", 1);
        expected.put("faculty3", 3);
        assertEquals(expected, result);
    }
}