
package ma.projet.service;

import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.beans.Femme;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;

public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public Femme getById(int id) {
        Femme femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = (Femme) session.get(Femme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return femmes;
    }

    @Override
    public List<Femme> getAll() {
        List<Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return femmes;
    }

    public List<Femme> getFemmesMarieesDeuxFoisOuPlus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Femme> femmes = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT f "
                    + "FROM Femme f "
                    + "WHERE f IN ("
                    + "   SELECT m.femme "
                    + "   FROM Mariage m "
                    + "   GROUP BY m.femme "
                    + "   HAVING COUNT(m.femme) >= 2"
                    + ")");
            femmes = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return femmes;
    }

    public int getNombreEnfantsEntreDates(Femme femme, Date d1, Date d2) {
        int nombreEnfants = 0;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("getNombreEnfantsEntreDates");
            query.setParameter("femmeId", femme.getId());
            query.setParameter("d1", d1);
            query.setParameter("d2", d2);
            nombreEnfants = query.getFirstResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return nombreEnfants;
    }

public Femme getFemmeLaPlusAgee() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Femme femmeLaPlusAgee = null;
    
    try {
        transaction = session.beginTransaction();
        
        // Utilisez une requête HQL pour obtenir la femme la plus âgée
        Query query = session.createQuery("FROM Femme ORDER BY dateNaissance ASC");
        query.setMaxResults(1); // Obtenir seulement le premier résultat (la femme la plus âgée).
        
        femmeLaPlusAgee = (Femme) query.uniqueResult();
        
        transaction.commit();
    } catch (HibernateException e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    
    return femmeLaPlusAgee;
}
}