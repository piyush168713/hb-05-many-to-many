// Main App
// file 2 of this hb-05 project
// copy of CreateCourseAndStudentsDemo.java

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForAshishDemo {
    public static void main(String[] args) {

        // Create Session factory
        SessionFactory factory = new Configuration()
                .configure("com/luv2code/jdbc/hibernate.cfg.xml")       // must specify the path of hibernate.cfg.xml file.
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)      // adding reference for new Course Class
                .addAnnotatedClass(Review.class)      // adding reference for new Review Class
                .addAnnotatedClass(Student.class)     // adding reference for new Student Class
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // get the student ashish from database
            int studentId = 4;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("\nLoaded Student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());

            // create more courses
            Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");

            // add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            // save the courses
            System.out.println("\nSaving the Courses...");

            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally{
            // add clean up code
            session.close();

            factory.close();
        }
    }
}
