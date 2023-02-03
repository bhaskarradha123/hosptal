package hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Hospital {
	@Id
	private int h_id;
	private String h_name;
	private String h_ceo;
	@OneToMany
	private List<Branch>branches;
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_ceo() {
		return h_ceo;
	}
	public void setH_ceo(String h_ceo) {
		this.h_ceo = h_ceo;
	}
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	@Override
	public String toString() {
		return "Hospital [h_id=" + h_id + ", h_name=" + h_name + ", h_ceo=" + h_ceo + ", branches=" + branches + "]";
	}


}
