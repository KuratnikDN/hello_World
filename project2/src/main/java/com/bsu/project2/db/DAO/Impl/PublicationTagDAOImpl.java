package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import util.HibernateUtil;

import logic.PublicationTag;
import DAO.PublicationTagDAO;

public class PublicationTagDAOImpl implements PublicationTagDAO{

	@Override
	public void addPublicationTag(PublicationTag o1) throws SQLException {
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
	public void updatePublicationTag(PublicationTag o1) throws SQLException {
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
	public PublicationTag getPublicationTagById(Long id) throws SQLException {
		Session session = null;
        PublicationTag publicationTag = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            publicationTag = (PublicationTag) session.load(PublicationTag.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return publicationTag;
	}

	@Override
	public List getAllPublicationTags() throws SQLException {
		Session session = null;
        List<PublicationTag> publicationTags = new ArrayList<PublicationTag>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            publicationTags = session.createCriteria(PublicationTag.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return publicationTags;
	}

	@Override
	public void deletePublicationTag(PublicationTag o1) throws SQLException {
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
