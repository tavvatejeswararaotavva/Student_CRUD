package com.springboot.cool.DAO;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.cool.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class StudentDAOImp implements StudentDAO {
	
	private EntityManager em;
	
	
	public StudentDAOImp(EntityManager em) {
		this.em = em;
	}


	@Override
	@Transactional
	public void save(Student s) {
		// TODO Auto-generated method stub
		em.persist(s);
	}


	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		Student s  = em.find(Student.class, id);
		return s;
	}


	@Override
	public List<Student> findAll() {
		TypedQuery<Student> the = em.createQuery("FROM Student",Student.class);
		return the.getResultList();
	}


	@Override
	@Transactional
	public void update(Student s) {
		// TODO Auto-generated method stub
		em.merge(s);
		
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		Student s = em.find(Student.class, id);
		em.remove(s);
	}


	@Override
	@Transactional
	public int deleteAll() {
		// TODO Auto-generated method stub
		int rowsno = em.createQuery("DELETE FROM Student").executeUpdate();
		return rowsno;
	}

}
