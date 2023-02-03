package hospital.dao;

import java.util.List;


import javax.persistence.*;

import hospital.dto.*;



public class Branchdao {
	public EntityManager getEntityManager(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("radha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
}
	public void saveBranch(List<Branch> list,int h_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class,h_id);
		if(hospital!=null){
			hospital.setBranches(list);
			
			entityTransaction.begin();
			for(Branch branch1:list){
				
				entityManager.persist(branch1);
			}
			entityManager.merge(hospital);
			entityTransaction.commit();
		}
		
		System.out.println("Inserted Successfully");
	
	}
	public void updateBranch(int b_id, String b_manager) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class,b_id);
		branch.setB_manager(b_manager);
		entityTransaction.begin();
		entityManager.merge(branch);
		entityManager.merge(branch.getAddress());
		entityTransaction.commit();
		System.out.println("Updated successfully");
	}
	public void deleteBranch(int b_id) {
		EntityManager entityManager =getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, b_id);
		if (branch!= null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityManager.remove(branch.getAddress());
			entityTransaction.commit();
		} else
			System.out.println("Invalid");
}
	public List<Branch> getBranch(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select b from Branch b");
		List<Branch> list=query.getResultList();
		return list;
	}
	
	
	
	
	

}
