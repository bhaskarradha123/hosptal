package hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hospital.dto.Encounter;
import hospital.dto.Person;


public class PersonDetail {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("radha");
		return entityManagerFactory.createEntityManager();
	}
	public void getEncounterDetails(int id) {
		EntityManager entityManager = getEntityManager();
		Encounter encounter =entityManager.find(Encounter.class, id);
		if(encounter !=null)
		{   
			System.out.println(encounter);
		}
		else {
			System.out.println("NO Such Id Found");
		}
	}
	
	

}
