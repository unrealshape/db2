package point;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	private Long id;
	private String name;
	@OneToMany(mappedBy = "vehicleOwner")
	private List<Vehicle> ownedVehicle;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Vehicle> getOwnedVehicle() {
		return ownedVehicle;
	}
	public void setOwnedVehicle(List<Vehicle> ownedVehicle) {
		this.ownedVehicle = ownedVehicle;
	}

	
	
	

}
