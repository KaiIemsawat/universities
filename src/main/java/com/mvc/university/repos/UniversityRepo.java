package com.mvc.university.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.university.models.University;

@Repository
public interface UniversityRepo extends CrudRepository<University, Long>{

	List<University> findAll(); // Select all
	
	List<University> findAllByOrderByNameDesc(); //  --> SELECT * FROM universities ORDER BY name DESC;
}
