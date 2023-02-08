package bubzki.mdf.entity;

import java.util.Map;

public class StatsCalculator {
    private static final StatsCalculator instance = new StatsCalculator();
    private String youngestStudent;
    private String oldestStudent;
    private float averageAge;
    private String popularDomain;
    private int sumduDomain;
    private int groups;
    private Map<String, Integer> faculties;

    private StatsCalculator () {}

    public static StatsCalculator getInstance() {
        return instance;
    }

    public String getYoungestStudent() {
        return youngestStudent;
    }

    public void setYoungestStudent(String youngestStudent) {
        this.youngestStudent = youngestStudent;
    }

    public String getOldestStudent() {
        return oldestStudent;
    }

    public void setOldestStudent(String oldestStudent) {
        this.oldestStudent = oldestStudent;
    }

    public float getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(float averageAge) {
        this.averageAge = averageAge;
    }

    public String getPopularDomain() {
        return popularDomain;
    }

    public void setPopularDomain(String popularDomain) {
        this.popularDomain = popularDomain;
    }

    public int getSumduDomain() {
        return sumduDomain;
    }

    public void setSumduDomain(int sumduDomain) {
        this.sumduDomain = sumduDomain;
    }

    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }

    public Map<String, Integer> getFaculties() {
        return faculties;
    }

    public void setFaculties(Map<String, Integer> faculties) {
        this.faculties = faculties;
    }
}
