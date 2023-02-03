package hospital.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Address {
	@Id
	private int building_no;
	private String street;
	private String district;
	private String state;
	private long pincode;
	public int getBuilding_no() {
		return building_no;
	}
	public void setBuilding_no(int building_no) {
		this.building_no = building_no;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [building_no=" + building_no + ", street=" + street + ", district=" + district + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
	
}
