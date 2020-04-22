package com.luv2code.jdbc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.hibernate.demo.entity.Course;
import com.luv2code.jdbc.hibernate.demo.entity.Instructor;
import com.luv2code.jdbc.hibernate.demo.entity.InstructorDetail;
import com.luv2code.jdbc.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to Scrore 100000 points");

            tempCourse.addReview(new Review("Great course ... loved it"));
            tempCourse.addReview(new Review("Cool course!!!"));
            tempCourse.addReview(new Review("What a dumb course!"));

            session.save(tempCourse);

            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
