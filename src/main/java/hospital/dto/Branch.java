package hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Branch {

	@Id
	private int b_id;
	private String b_location;
	private String b_manager;
	 @OneToOne
	 private Address address;
	 @ManyToOne
	private Encounter encounter;
	 

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getB_id() {    
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_location() {
		return b_location;
	}

	public void setB_location(String b_location) {
		this.b_location = b_location;
	}

	public String getB_manager() {
		return b_manager;
	}

	public void setB_manager(String b_manager) {
		this.b_manager = b_manager;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	@Override
	public String toString() {
		return "Branch [b_id=" + b_id + ", b_location=" + b_location + ", b_manager=" + b_manager + ", address="
				+ address +  "] \n ";
	}

}
