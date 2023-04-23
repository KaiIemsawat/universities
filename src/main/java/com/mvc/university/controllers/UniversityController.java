package com.mvc.university.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.university.models.University;
import com.mvc.university.services.UniversityService;

@Controller
public class UniversityController {
	@Autowired
	private UniversityService uServ;
	
	@GetMapping("")
	public String homeRoute() {
		return "redirect:/universities";
	}
	
//	Page that displays all universities
	@GetMapping("/universities")
	public String allUniversitiesPage(Model model) {
		model.addAttribute("universities", uServ.getAllUniversities());
		return "universities";
	}
	
//	Page that displays a form to add a university
	@GetMapping("/universities/new")
	public String newUniversityPage(@ModelAttribute("newUniversity") University university) {
		return "newUniversity";
	}
	
//	Page to show a university
	@GetMapping("/universities/{id}")
	public String viewUniversity(Model model, @PathVariable("id") Long id) {
		model.addAttribute("thisUniversity", uServ.getUniversityById(id));
		return "viewUniversity";
	}
	
	
//	'POST' route that adds a university to the database
	@PostMapping("/universities/new")
	public String addUniveristyToDB(
			@Valid @ModelAttribute("newUniversity") University university
			, BindingResult res
			) {
		if(res.hasErrors()) { // <-- if validation fail
			return "newUniversity";
		}
//		If validation succeed, save it!!
		uServ.addOrUpdateUniversity(university);
		return "redirect:/";
	}
	
//	Page that user can edit a university
	@GetMapping("/universities/{id}/edit")
	public String editUniversityPage(@PathVariable Long id, Model model) {
		model.addAttribute("university", uServ.getUniversityById(id));
		return "editU";
	}
	
//	'PUT' request route to edit a university
	@PutMapping("/universities/{id}/edit")
	public String editUniveristyInDB(
			@Valid @ModelAttribute("university") University university
			, BindingResult res
			, @PathVariable Long id
			) {
		if(res.hasErrors()) { // <-- if validation fail
			return "editU";
		}
//		If validation succeed, save it!!
		uServ.addOrUpdateUniversity(university);
		return "redirect:/";
	}
	
//	Delete a university
	@GetMapping("/universities/{id}/delete")
	@DeleteMapping("/universities/{id}/delete")
	public String deleteAUniversity(@PathVariable("id") Long id) {
		uServ.deleteUniversity(id);
		return "redirect:/universities";
	}
	
	
	
}
