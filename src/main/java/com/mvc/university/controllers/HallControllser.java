package com.mvc.university.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.university.models.Hall;
import com.mvc.university.services.HallService;
import com.mvc.university.services.UniversityService;

@Controller
public class HallControllser {
	
	@Autowired
	private HallService hServ;
	@Autowired
	private UniversityService uServ;
	
//	All halls page
	@GetMapping("/halls")
	public String getAllHallsPage() {
		return "";
	}
	
//	Create new hall page
	@GetMapping("/halls/new")
	public String newHallPage(
			@ModelAttribute("newHall") Hall newHall
			, Model model
			) {
		model.addAttribute("universities", uServ.getAllUniversities());
		return "newHall";
	}
	
//	View the hall page
	@GetMapping("/halls/{id}")
	public String getAllHallsPage(@PathVariable Long id) {
		return "";
	}
	
//	Edit the hall page
	@GetMapping("/halls/{id}/edit")
	public String editTheHallPage(@PathVariable Long id) {
		return "";
	}
	
//	Add a hall into DB
	@PostMapping("/halls/new")
	public String addAHallToDB(
			@Valid @ModelAttribute("newHall") Hall newHall
			, BindingResult res
			, Model model
			) {
		if(res.hasErrors()) { // <-- if validation fail
			model.addAttribute("universities", uServ.getAllUniversities());
			return "newHall";
		}
//		If validation succeed, save it!!
		hServ.addOrUpdateHall(newHall);
		return "redirect:/halls";
	}
	
//	Edit the hall in DB
	@PostMapping("/halls/{id}/edit")
	public String editAHall(@PathVariable Long id) {
		return "redirect:/halls";
	}
	
//	Route to delete a hall from DB
	@RequestMapping(value="/halls/{id}/delete", method={RequestMethod.GET, RequestMethod.DELETE})
	public String deleteAHallFromDB(@PathVariable Long id) {
		return "redirect:/halls";
	}
}
