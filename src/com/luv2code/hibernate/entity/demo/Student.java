package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Map class to database table,(line 10-12)   this is basically annotation or mapping these java file to the appropriate database columns.
@Entity
@Table(name="student")
public class Student {

    // Map fields to database columns (line 15-26)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name="course_student",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;

    public Student(){              // no-arg constructor

    }

    // constructor defined
    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getter and setter methods
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // getter/setter for Course list
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    // toString() is mainly use for debugging process.
    public String toString(){
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }


}
