package com.mvc.university.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.university.models.Hall;

@Repository
public interface HallRepo extends CrudRepository<Hall, Long>{
	List<Hall> findAll();
	
	List<Hall> findAllByOrderByHallNameDesc(); // <-- SELECT * FROM halls ORDER BY DESC;
//	List<University> findAllByOrderByNameDesc(); //  --> SELECT * FROM universities ORDER BY name DESC;

}
