package hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class MedItems {
	
	@Id
	
	private int meditems_id;
	private String meditems_name;
	private int meditems_pills;
	private double meditems_cost;
	@ManyToOne
	private MedOrder orders;
	
	public  MedOrder getMedOrder() {
		return  orders;
	}
	public void setMedOrder( MedOrder orders) {
		this.orders = orders;
	}
	
	public int getMeditems_id() {
		return meditems_id;
	}
	public void setMeditems_id(int meditems_id) {
		this.meditems_id = meditems_id;
	}
	public String getMeditems_name() {
		return meditems_name;
	}
	public void setMeditems_name(String meditems_name) {
		this.meditems_name = meditems_name;
	}
	public int getMeditems_pills() {
		return meditems_pills;
	}
	public void setMeditems_pills(int meditems_pills) {
		this.meditems_pills = meditems_pills;
	}
	public double getMeditems_cost() {
		return meditems_cost;
	}
	public void setMeditems_cost(double meditems_cost) {
		this.meditems_cost = meditems_cost;
	}
	
	
	@Override
	public String toString() {
		return "MedItems [meditems_id=" + meditems_id + ", meditems_name=" + meditems_name + ", meditems_pills="
				+ meditems_pills + ", meditems_cost=" + meditems_cost + "]";
	}
	
	
	

}
