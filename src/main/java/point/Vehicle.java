package point;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	private Long id;
	private String licensePlateNumber;
	@ManyToOne
	private Person vehicleOwner;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	public Person getVehicleOwner() {
		return vehicleOwner;
	}
	public void setVehicleOwner(Person vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}



}
