package servelt_login_validation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import servelt_login_validation.dto.EmployeeDto1;






public class Employeedao {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();
    
    
	public String create(EmployeeDto1 dto) {
		// TODO Auto-generated method stub
		et.begin();
		em.persist(dto);
		et.commit();
		
		
		return "data is inserted";
	}


	public EmployeeDto1 login(String mail) {
		// TODO Auto-generated method stub
		EmployeeDto1 d=em.find(EmployeeDto1.class, mail);
		//System.out.println(d.getPassword());
		return d;
	}
	
	
	
}
