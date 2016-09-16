package dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import database.HibernateUtil;
import models.UserDetails;
import models.Vehicles;

public class UserAddEditDao {
	Session session = null;
	Transaction tx = null;
	int i = 0;
	
	public void insertUser(String userName,String userAddress,String phoneNumber,String[] userVehicles) throws SQLException {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(userName);
		userDetails.setUserAddress(userAddress);
		userDetails.setUserPhone(phoneNumber);
		for(i=0;i<userVehicles.length;i++)
		{
			Vehicles vehicle = new Vehicles();
			vehicle.setVehicleId(Integer.parseInt(userVehicles[i]));
			vehicle.setVehicleName("vehicle"+userVehicles[i]);
			userDetails.getVehicles().add(vehicle);
			vehicle.setUser(userDetails);
		}
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(userDetails);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
		
	}
	
	public UserDetails getUserDetails(int userId)
	{
		UserDetails userDetailsObj = new UserDetails();

        try{
        	userDetailsObj = null;
        	session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			userDetailsObj = (UserDetails) session.get(UserDetails.class, userId);
        }catch(HibernateException e)
        {
        	e.printStackTrace();
        }finally {
			session.close(); 
		}
        return userDetailsObj;
	}
	
	public void editUser(String userName,String userAddress,String phoneNumber,int userId) throws SQLException {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			UserDetails userDetails = (UserDetails) session.load(UserDetails.class, userId);
			userDetails.setUserName(userName);
			userDetails.setUserAddress(userAddress);
			userDetails.setUserPhone(phoneNumber);
			session.update(userDetails);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
	}
}
