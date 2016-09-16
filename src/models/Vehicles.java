package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="vehicles")
public class Vehicles {
	@Id
	@Column(name = "vehicle_id")
	private int vehicleId;
	@Column(name = "vehicle_name")
	private String vehicleName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	private UserDetails user;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
}
