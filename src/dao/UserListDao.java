package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import database.HibernateUtil;
import models.UserDetails;

@SuppressWarnings("deprecation")
public class UserListDao {
	Session session = null;
	
	public List<UserDetails> listUsers() throws SQLException {
		List<UserDetails> userDetails = new ArrayList<UserDetails>();
        try{
        	session = HibernateUtil.getSessionFactory().openSession();
        	userDetails = session.createCriteria(UserDetails.class).list();
			
        }catch(HibernateException e)
        {
        	e.printStackTrace();
        }finally {
			session.close(); 
		}
        
        return userDetails;
    }
}
