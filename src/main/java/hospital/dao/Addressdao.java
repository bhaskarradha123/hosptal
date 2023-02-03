package hospital.dao;

import java.util.List;


import javax.persistence.*;

import hospital.dto.*;


public class Addressdao {
	public EntityManager getEntityManager(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
}
	public void saveAddress(Address address,int b_id){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, b_id);
		branch.setAddress(address);
		entityTransaction.begin();
		entityManager.persist(address);
		entityManager.merge(branch);
		entityTransaction.commit();
	}
	public void updateAddress(int building_no,String street){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address=entityManager.find(Address.class, building_no);
		address.setBuilding_no(building_no);
		address.setStreet(street);
		entityTransaction.begin();
		entityManager.merge(address);
		entityTransaction.commit();	
	}
	public void deleteAddress(int id) {
		EntityManager entityManager =getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address = entityManager.find(Address.class, id);
		if (address!= null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
		} else
			System.out.println("Invalid");
	}
	public List<Address> getAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Address e");
		List<Address> list = query.getResultList();
		return list;
	}
}
