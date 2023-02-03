package hospital.dao;

import java.util.*;


import javax.persistence.*;

import hospital.dto.Branch;
import hospital.dto.Hospital;


public class Hospitaldao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("radha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveHospital(Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		List<Branch>list=new ArrayList<Branch>();
		entityTransaction.begin();
		 entityManager.persist(hospital);
		entityTransaction.commit();
	}

	public void updateHospital(int h_id, Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital2 = entityManager.find(Hospital.class, h_id);
		List<Branch> branches = hospital2.getBranches();
		entityTransaction.begin();
		entityManager.merge(hospital2);
		entityTransaction.commit();
	}

	public void deleteHospital(int h_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital = entityManager.find(Hospital.class, h_id);
		entityTransaction.begin();
		entityManager.remove(hospital);
		entityTransaction.commit();
	}

	public List<Branch> getHospital() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select h from Hospital h");
		List<Branch> list = query.getResultList();
		return list;
	}

}
