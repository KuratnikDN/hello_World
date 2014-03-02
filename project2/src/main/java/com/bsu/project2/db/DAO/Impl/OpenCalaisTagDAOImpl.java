package DAO.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import util.HibernateUtil;

import logic.OpenCalaisTag;
import DAO.OpenCalaisTagDAO;

public class OpenCalaisTagDAOImpl implements OpenCalaisTagDAO {

	@Override
	public void addOpenCalaisTag(OpenCalaisTag o1) throws SQLException {
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
	public void updateOpenCalaisTag(OpenCalaisTag o1) throws SQLException {
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
	public OpenCalaisTag getOpenCalaisTagById(Long id) throws SQLException {
		 Session session = null;
         OpenCalaisTag oct = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             oct = (OpenCalaisTag) session.load(OpenCalaisTag.class, id);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
         } finally {
             if (session != null && session.isOpen()) {
                 session.close();
             }
         }
         return oct;
	}

	@Override
	public List getAllOpenCalaisTags() throws SQLException {
		Session session = null;
        List<OpenCalaisTag> oct = new ArrayList<OpenCalaisTag>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            oct = session.createCriteria(OpenCalaisTag.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return oct;
	}

	@Override
	public void deleteOpenCalaisTag(OpenCalaisTag o1) throws SQLException {
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
