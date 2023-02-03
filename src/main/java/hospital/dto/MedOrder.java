package hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class MedOrder {
	
	@Id
	
	private int medorder_id;
	private String medorder_name;
	private int medorder_age;
	private String medorder_date;
	@ManyToOne
	private Encounter encounter;
	
	
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	public int getMedorder_id() {
		return medorder_id;
	}
	public void setMedorder_id(int medorder_id) {
		this.medorder_id = medorder_id;
	}
	public String getMedorder_name() {
		return medorder_name;
	}
	public void setMedorder_name(String medorder_name) {
		this.medorder_name = medorder_name;
	}
	public int getMedorder_age() {
		return medorder_age;
	}
	public void setMedorder_age(int medorder_age) {
		this.medorder_age = medorder_age;
	}
	public String getMedorder_date() {
		return medorder_date;
	}
	public void setMedorder_date(String medorder_date) {
		this.medorder_date = medorder_date;
	}
	@Override
	public String toString() {
		return "MedOrder [medorder_id=" + medorder_id + ", medorder_name=" + medorder_name + ", medorder_age="
				+ medorder_age + ", medorder_date=" + medorder_date +  "]";
	}
	
	

}
