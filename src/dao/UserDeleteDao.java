package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import database.HibernateUtil;
import models.UserDetails;

public class UserDeleteDao {
	Session session = null;
	Transaction tx = null;
	
	public void deleteUser(int userId)
	{
		UserDetails userDetailsObj = new UserDetails();
		try {
			userDetailsObj = null;
        	session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			userDetailsObj = session.load(UserDetails.class, userId);
			if (userDetailsObj != null) {
			    session.delete(userDetailsObj);
			}
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
	}
}
