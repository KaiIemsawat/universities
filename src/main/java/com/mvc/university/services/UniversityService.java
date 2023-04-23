package com.mvc.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.university.models.University;
import com.mvc.university.repos.UniversityRepo;

@Service
public class UniversityService  {

	@Autowired
	private UniversityRepo uRepo;
	
	/* Methods to interact with repository */
	
//	Add or Update university
	public University addOrUpdateUniversity(University newUniversity) {
		return uRepo.save(newUniversity);
	}
//	Get all universities
	public List<University> getAllUniversities() {
		return uRepo.findAll();
	}
	
//	Get one university
	public University getUniversityById(Long uId) {
		return uRepo.findById(uId).orElse(null);
	}
	
	
//	Delete a university
	public void deleteUniversity(Long uId) {
		uRepo.deleteById(uId);
	}
}
