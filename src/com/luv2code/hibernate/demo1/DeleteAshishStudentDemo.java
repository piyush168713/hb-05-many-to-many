// Main App
// file 5 of this hb-05 project
// copy of GetCoursesForAshishDemo.java

// Delete a student
// Confirm that course is not deleted
// Only delete the Course-Student relationship

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteAshishStudentDemo {
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

            // get the student from database
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());

            // delete the student
            System.out.println("Deleting the student: " + tempStudent);
            session.delete(tempStudent);

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
