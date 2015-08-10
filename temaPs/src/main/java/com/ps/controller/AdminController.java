package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.entity.User;
import com.ps.service.UserService;


@Controller
public class AdminController {

	
	@Autowired
	private UserService userService;
	
	//////
	//CREATE
	@RequestMapping("/admin-add-user")
	public String getAddUser(Model model) {

		model.addAttribute("user", new User());
		System.out.println("HERE");
		return "admin-add-user";
	}
	

			
			
	@RequestMapping(value = "/admin-add-user", method = RequestMethod.POST)
	public String postAddUser(@ModelAttribute("user") User user) {

		userService.save(user);
		System.out.println("Inserted!");
		return "admin-add-user";
	}
	
	//////////////////////////////////////////////
	// READ
	@RequestMapping("/admin-get-all-users")
	public String getSeeUsers(Model model) {

		model.addAttribute("userList", userService.getAll() );
		
		for(User u : userService.getAll()){
			System.out.println(u.getFirstName());
		}
		System.out.println();
		System.out.println("HERE GETALL");
		return "admin-get-all-users";
	}
	
	@RequestMapping(value = "/admin-get-all-users", method = RequestMethod.POST)
	public String postGetAllUsers(@ModelAttribute("user") User user) {

		userService.save(user);
		System.out.println("Inserted!");
		return "admin-get-all-users";
	}
	
	/////////////////////////////////
	//DELETE
	@RequestMapping("/admin-delete-user")
	public String getDeleteUser(Model model) {

		model.addAttribute("userList", userService.getAll() );
		
		for(User u : userService.getAll()){
			System.out.println(u.getFirstName());
		}
		System.out.println();
		System.out.println("DELETE GET");
		return "admin-delete-user";
	}
	
	@RequestMapping(value = "/admin-delete-users/{id}", method = RequestMethod.GET)
	public String postDeleteUser(@PathVariable("id") int id) {

		userService.delete(id); 
		System.out.println("DELETED!");
		return "redirect:/admin-delete-user";
	}
	
	///////////////
	// EDIT
	@RequestMapping(value="/admin-edit-user/{id}",method = RequestMethod.GET)
	public String getEditUser(Model model,@PathVariable("id") int id) {

		model.addAttribute("user", userService.findOne(id) );
		
		
		
		System.out.println("edit GET");
		return "admin-edit-user";
	}
	
	@RequestMapping(value = "/admin-edit-user/{id}", method = RequestMethod.POST)
	public String postEditUser (@ModelAttribute("user") User user) {

		userService.save(user); 
		System.out.println("edited!");
		return "redirect:/admin-delete-user";
	}
}
