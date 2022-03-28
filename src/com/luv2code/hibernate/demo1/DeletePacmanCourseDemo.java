// Main App
// file 4 of this hb-05 project
// copy of GetCoursesForAshishDemo.java

// Delete a course
// Confirm that student is not deleted
// Only delete the Course-Student relationship

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
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

            // get the pacman course from db
            int courseId = 12;
            Course tempCourse = session.get(Course.class, courseId);

            // delete the course
            System.out.println("Deleting Course: " + tempCourse);
            session.delete(tempCourse);

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
