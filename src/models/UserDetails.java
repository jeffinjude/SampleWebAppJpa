package models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="userdetails")
public class UserDetails {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_address")
	private String userAddress;
	@Column(name = "user_phone")
	private String userPhone;
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="user_vehicles", joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="vehicle_id")
	)
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<Vehicles> vehicles = new ArrayList<Vehicles>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Collection<Vehicles> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}
}
