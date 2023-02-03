package hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Encounter {
	
	@Id
	
	private int encounter_a_id;
	private String  encounter_disease;
	private String enounter_date;
	
	
	@ManyToOne
	private Person person;
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getEncounter_a_id() {
		return encounter_a_id;
	}

	public void setEncounter_a_id(int encounter_a_id) {
		this.encounter_a_id = encounter_a_id;
	}

	public String getEncounter_disease() {
		return encounter_disease;
	}

	public void setEncounter_disease(String encounter_disease) {
		this.encounter_disease = encounter_disease;
	}

	public String getEnounter_date() {
		return enounter_date;
	}

	public void setEnounter_date(String enounter_date) {
		this.enounter_date = enounter_date;
	}

	

	@Override
	public String toString() {
		return "Encounter [encounter_a_id=" + encounter_a_id + ", encounter_disease=" + encounter_disease
				+ ", enounter_date=" + enounter_date +  "]";
	}


}
