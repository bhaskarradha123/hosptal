package hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Person {
	
	@Id
	private int person_id;
	private String person_name;
	private long person_phone;
	private String person_address;
	
	
	
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public long getPerson_phone() {
		return person_phone;
	}
	public void setPerson_phone(long person_phone) {
		this.person_phone = person_phone;
	}
	public String getPerson_address() {
		return person_address;
	}
	public void setPerson_address(String person_address) {
		this.person_address = person_address;
	}
	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_phone=" + person_phone
				+ ", person_address=" + person_address + "]";
	}
	
	
	

}
