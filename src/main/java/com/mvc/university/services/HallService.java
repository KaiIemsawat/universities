package com.mvc.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.university.models.Hall;
import com.mvc.university.repos.HallRepo;

@Service
public class HallService {
	@Autowired
	private HallRepo hRepo;
	
//	To save when create a new hall or when update a hall
	public Hall addOrUpdateHall(Hall hall) {
		return hRepo.save(hall);
	}
	
//	Get all halls
	public List<Hall> getAllHalls() {
		return hRepo.findAll();
	}
	
//	Get all halls in DESC name order
	public List<Hall> getAllHallsDESCName() {
		return hRepo.findAllByOrderByHallNameDesc();
	}
	
//	Get a hall by id
	public Hall getTheHall(Long id) {
		return hRepo.findById(id).orElse(null);
	}
}
