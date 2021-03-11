import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saj
 */
public class Course {
    private String courseName;
    private int noOfStudents;
    private String teacher;
    public static int instances = 0;

    //Getters
    public String getCourseName(){
        return this.courseName;
    }
    public int getNoOfStudents(){
        return this.noOfStudents;
    }
    public String getTeacher(){
        return this.teacher;
    }

    //Setters
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setNoOfStudents(int noOfStudents){
        this.noOfStudents = noOfStudents;
    }
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }


    public Course(){
        instances++;
        this.noOfStudents = 5;
        this.courseName = "Not Set";
        this.teacher = "Not Set";
    }


    public Course(int noOfStudents, String courseName, String teacher){
        this.noOfStudents = noOfStudents;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public static int getInstances() {
        return instances;
    }

    public static void setInstances(int instances) {
        Course.instances = instances;
    }
}