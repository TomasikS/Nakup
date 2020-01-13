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
            transaction = session.beginTransaction();
            session.save(nakup);
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
          
            transaction = session.beginTransaction();

            
            Nakup nakup = session.get(Nakup.class, id);
            if (nakup != null) {
                session.delete(nakup);
                
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }





}
