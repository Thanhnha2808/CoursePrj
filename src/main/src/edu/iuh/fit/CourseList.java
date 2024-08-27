/**
 * @description:
 * @author: Thanh Nha
 * @version: 1.0
 * @created: 8/23/2024 9:56 PM
 */
package edu.iuh.fit;

import java.util.Arrays;

/**
 * Description: This class represents a list of courses
 */
public class CourseList {

    private Course[] courses;
    private static int count = 0;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length n
     * @param n The length of the array
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n]; // create an array of n elements
    }

    /**
     * Description: Add a course to the list
     * @param course
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     */
    public boolean addCourse(Course course) {
        //  check if course is null
        if(course == null)
            return false;
        //  check if course already exists
        if(exists(course)) //Check if id of course duplicate
            return false;
        //  check if the array is full
        if (count == courses.length)
            return false;
        //  add course to the array
        courses[count++] = course;
        return true;
    }

    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @param course The course to check
     * @return true if the course exists, false otherwise
     */
    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    public Course[] getCourses() {
        return courses;
    }
}