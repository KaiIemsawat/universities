package com.mvc.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.university.models.Hall;
import com.mvc.university.models.University;
import com.mvc.university.repos.HallRepo;
import com.mvc.university.repos.UniversityRepo;

@Service
public class UniversityService  {

	@Autowired
	private UniversityRepo uRepo;
	@Autowired
	private HallRepo hRepo;
	
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
		
//		Disconnect each hall from this university before it is deleted
		University thisUniversity = this.getUniversityById(uId);
//		Go through all halls in the university
		for(Hall hall : thisUniversity.getHalls()) {
			hall.setUniversity(null); // <-- Unassigns the hall(s) form the university that is being deleted
			hRepo.save(hall); // <-- save the updated hall(s)
		}
		
		uRepo.deleteById(uId);
	}
}
