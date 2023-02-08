package bubzki.mdf.util;

import bubzki.mdf.entity.Student;
import bubzki.mdf.exception.AgeException;
import bubzki.mdf.exception.EmailException;

import java.util.*;
import java.util.regex.Pattern;

public class Utils {
    public static String calculateYoungestStudent(LinkedList<Student> students)
            throws AgeException {
        try {
            String student = "";
            int minAge = Integer.MAX_VALUE;
            for(Student temp : students) {
                int tempAge = Integer.parseInt(temp.getAge());
                if(tempAge < minAge) {
                    minAge = tempAge;
                    student = temp.getName() + " " + temp.getSurname();
                }
            }
            return student;
        } catch (NumberFormatException e) {
            throw new AgeException();
        }
    }

    public static String calculateOldestStudent(LinkedList<Student> students)
            throws AgeException {
        try {
            String student = "";
            int maxAge = Integer.MIN_VALUE;
            for(Student temp : students) {
                int tempAge = Integer.parseInt(temp.getAge());
                if(tempAge > maxAge) {
                    maxAge = tempAge;
                    student = temp.getName() + " " + temp.getSurname();
                }
            }
            return student;
        } catch (NumberFormatException e) {
            throw new AgeException();   
        }
    }

    public static float calculateAverageAge(LinkedList<Student> students)
            throws AgeException {
        try {
            int averageAge = 0;
            for(Student temp : students) {
                averageAge += Integer.parseInt(temp.getAge());
            }
            return (float)averageAge / (float)students.size();
        } catch (NumberFormatException e) {
            throw new AgeException();
        }
    }

    public static String calculatePopularDomain(LinkedList<Student> students)
            throws EmailException {
        Map<String, Integer> domains = new HashMap<>();
        String popularDomain = "";
        for(Student temp : students) {
            if(patternMatches(temp.getEmail())) {
                String tempDomain = getEmailDomain(temp.getEmail());
                if(domains.containsKey(tempDomain)) {
                    domains.put(tempDomain, domains.get(tempDomain) + 1);
                } else {
                    domains.put(tempDomain, 1);
                }
            } else {
                throw new EmailException();
            }
        }
        Set<String> keys = domains.keySet();
        int maxDomain = 0;
        for(String tempKey : keys) {
            if(domains.get(tempKey) > maxDomain) {
                maxDomain = domains.get(tempKey);
                popularDomain = tempKey;
            }
        }
        return popularDomain;
    }

    public static int calculateSumduDomain(LinkedList<Student> students)
            throws EmailException {
        int quantityDomain = 0;
        final String DOMAIN = "sumdu";
        for(Student temp : students) {
            if(patternMatches(temp.getEmail())) {
                if (getEmailDomain(temp.getEmail()).contains(DOMAIN)) {
                    quantityDomain++;
                }
            } else {
                throw new EmailException();
            }
        }
        return quantityDomain;
    }

    public static int calculateGroups(LinkedList<Student> students) {
        Set<String> groups = new HashSet<>();
        for(Student temp : students) {
            groups.add(temp.getGroup());
        }
        return groups.size();
    }

    public static Map<String, Integer> calculateStudentsFromFaculty(LinkedList<Student> students) {
        Map<String, Integer> faculties = new HashMap<>();
        for(Student temp : students) {
            if(faculties.containsKey(temp.getFaculty())) {
                faculties.put(temp.getFaculty(), faculties.get(temp.getFaculty()) + 1);
            } else {
                faculties.put(temp.getFaculty(), 1);
            }
        }
        return faculties;
    }

    private static boolean patternMatches(String email) {
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    private static String getEmailDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }
}
