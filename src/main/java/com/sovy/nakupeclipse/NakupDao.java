package com.sovy.nakupeclipse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.PostConstruct;

import static com.sovy.nakupeclipse.HibernateUtil.getSessionFactory;


public class NakupDao {

    private Session session;

    @PostConstruct
    public void setUp() {
        this.session = getSessionFactory().openSession();
    }


    public Nakup getNakupById(Long id) {
        Nakup student = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
//            student = session.byId(Nakup.class).getReference(id);
            student = session.get(Nakup.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return student;
    }

    public void saveNakup(Nakup nakup) {
        Transaction transaction = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(nakup);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteNakup(int id) {
        Transaction transaction = null;
        try {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a persistent object
            Nakup nakup = session.get(Nakup.class, id);
            if (nakup != null) {
                session.delete(nakup);
                // System.out.println("student 1 is deleted");
            }

            // Delete a transient object
         /*   Student student2 = new Student();
            student2.setId(2);
            session.delete(student2);
            System.out.println("Student 2 is deleted");*/

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }





}
