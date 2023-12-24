package edu.touro.ds.model;

import java.util.Arrays;
import java.util.List;

/**
 * Utility class to manage aspects of LanderStudent objects
 */
public class LanderStudentUtils {

    private LanderStudentUtils() {
    }


    /**
     * Generate demonstration/test data
     *
     * @return List of Students
     */
    static public List<LanderStudent> generateDemoStudents() {
        return Arrays.asList(
                new LanderStudent("Sill", "Daniel", true, 2000),
                new LanderStudent("Greenspan", "Steve", true, 2002),
                new LanderStudent("Kennedy", "Tom", true, 1999),
                new LanderStudent("Artzt", "Russell", true, 1955)
        );
    }


}
