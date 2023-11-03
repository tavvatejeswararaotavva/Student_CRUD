package com.springboot.cool.DAO;

import java.util.List;

import com.springboot.cool.Entity.Student;

public interface StudentDAO {
	public void save(Student s);
	public Student findById(Integer id);
	public List<Student> findAll();
	public void update(Student s);
	public void delete(Integer id);
	public int deleteAll();
}
