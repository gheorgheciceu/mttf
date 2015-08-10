package com.ps.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;





import com.ps.entity.Customer;
import com.ps.entity.User;
import com.ps.service.CustomerService;
import com.ps.service.UserService;
import com.ps.utils.FileParser;

@Controller
public class UserController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired UserService userService;
	//CREATE
		@RequestMapping("/user-add-customer")
		public String getAddUser(Model model) {

			model.addAttribute("customer", new Customer());
			System.out.println("HERE");
			return "user-add-customer";
		}
		

				
				
		@RequestMapping(value = "/user-add-customer", method = RequestMethod.POST)
		public String postAddUser(@ModelAttribute("customer") Customer customer) {

			customerService.save(customer);
			System.out.println("Inserted CUSTOMER!");
			return "user-add-customer";
		}
		
		/////
		// read all
		@RequestMapping("/user-get-all-customers")
		public String getSeeCustomers(Model model) {

			model.addAttribute("customerList", customerService.getAll() );
			
			for(Customer u : customerService.getAll()){
				System.out.println(u.getFirstName());
			}
			System.out.println();
			System.out.println("HERE GETALL");
			return "user-get-all-customers";
		}
		//////////
		// UPDATE CUSTOMER
		@RequestMapping(value="/user-edit-customer/{id}",method = RequestMethod.GET)
		public String getEditCustomer(Model model,@PathVariable("id") int id) {

			model.addAttribute("customer", customerService.findOne(id) );
			
			
			
			System.out.println("edit GET");
			return "user-edit-customer";
		}
		
		@RequestMapping(value = "/user-edit-customer/{id}", method = RequestMethod.POST)
		public String postEditUser (@ModelAttribute("customer") Customer customer) {

			customerService.save(customer); 
			System.out.println("edited!");
			return "redirect:/user-get-all-customers";
		}
		
		@RequestMapping(value = "/profile", method = RequestMethod.GET)
		public String getProfile( Model model)
				throws IOException {

			String email = SecurityContextHolder.getContext().getAuthentication()
					.getName();

			User employee = userService.findByEmail(email);
			if (employee.getImage() != null) {

				String image = new String(Base64.encode(employee.getImage()));

				model.addAttribute("image", image);
				model.addAttribute("ok", employee.getUsername());
				System.out.println("aici");
				return "profile";
			}
			System.out.println("aici2");
			return "profile";
		}
		@RequestMapping(value = "/profile", method = RequestMethod.POST)
		public String postProfile(
				@RequestParam MultipartFile fileData, Model model)
				throws IOException {

			String email = SecurityContextHolder.getContext().getAuthentication()
					.getName();

			User employee = userService.findByEmail(email);
			employee.setImage(FileParser.readBytesFromFile(fileData));

			String image = new String(Base64.encode(employee.getImage()));
			model.addAttribute("image", image);
			model.addAttribute("ok", employee.getUsername());

			userService.save(employee);
			System.out.println("ok");
			return "profile";
		}
		@RequestMapping(value = "/max-transfer", method = RequestMethod.GET)
		public String getTransferable(){
			return "max-transfer";
		}
		
		@RequestMapping(value = "/max-transfer", method = RequestMethod.POST)
		public String postTransferable(@RequestParam("ammount") int max){
			userService.setMaximumTransferable(max);
			return "max-transfer";
		}
}
