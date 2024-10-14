
package ma.projet.services;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TacheService  implements IDao<Tache> {

    @Override
    public boolean create(Tache o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

   

    @Override
    public Tache getById(int id) {
        Tache tache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache = (Tache) session.get(Tache.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return tache;
    }

    @Override
    public List<Tache> getAll() {
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return taches;
    }
       public void getProjectsManagedByEmployee(Tache tache) {
         List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            Query query = session.getNamedQuery("getTasksWithPriceGreaterThan1000");
            taches = query.list();
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
        
        if (taches.isEmpty()) {
            System.out.println("Aucune tâche réalisée par " + tache.getNom());
        } else {
            System.out.println("taches réalisées par " + tache.getNom() + ":");
            for (Tache p : taches) {
                System.out.println(p.getNom());
            }
        }
    }
       public List<Tache> getBetweenDate(Date d1, Date d2) {
        List<Tache> taches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedQuery("findBetweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
            return taches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return taches;
        } finally {
            if(session != null)
                session.close();
        }
    }
}

