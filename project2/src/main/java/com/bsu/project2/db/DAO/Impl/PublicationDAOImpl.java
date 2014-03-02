package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import util.HibernateUtil;

import logic.Publication;
import DAO.PublicationDAO;

public class PublicationDAOImpl implements PublicationDAO{

	@Override
	public void addPublication(Publication o1) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o1);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	@Override
	public void updatePublication(Publication o1) throws SQLException {
		 Session session = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             session.update(o1);
             session.getTransaction().commit();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
         } finally {
             if (session != null && session.isOpen()) {
                 session.close();
             }
         }
		
	}

	@Override
	public Publication getPublicationById(Long id) throws SQLException {
		 Session session = null;
         Publication publication = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             publication = (Publication) session.load(Publication.class, id);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
         } finally {
             if (session != null && session.isOpen()) {
                 session.close();
             }
         }
         return publication;
	}

	@Override
	public List getAllPublications() throws SQLException {
		Session session = null;
        List<Publication> publications = new ArrayList<Publication>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            publications = session.createCriteria(Publication.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return publications;
	}

	@Override
	public void deletePublication(Publication o1) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(o1);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

}
