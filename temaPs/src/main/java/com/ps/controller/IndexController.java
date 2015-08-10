package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.component.EmailSender;
import com.ps.entity.Admin;
import com.ps.entity.User;
import com.ps.service.AdminService;
import com.ps.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private EmailSender emailSender;

	@RequestMapping("/")
	public String getIndex(Model model) {

		return "index";
	}

	@RequestMapping("/login")
	public String getMyLogin() {

		return "login";
	}

	@RequestMapping("/password-reset")
	public String getPasswordReset() {

		return "password-reset";
	}

	@RequestMapping(value = "/password-reset", method = RequestMethod.POST)
	public String postPasswordReset() {
		String email = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		
		Admin a = adminService.findByEmail(email);

		User u = userService.findByEmail(email);
		
		if (a != null) {
			emailSender.sendEmail(email, "gh.iservit@gmail.com",
					"Resetare parola",
					"Parola dumneavoastra a fost resetata cu success!\n"
							+ "Noua dumneavoastra parola este: "
							+ " \"admin\" ");
			a.setPassword("admin");
			System.out.println("RESET SDM PWD");
			return "password-reset";
		}
		
		if (u!= null) {
			emailSender.sendEmail(email, "gh.iservit@gmail.com",
					"Resetare parola",
					"Parola dumneavoastra a fost resetata cu success!\n"
							+ "Noua dumneavoastra parola este: "
							+ " \"user\" ");
			u.setPassword("admin");
			System.out.println("RESET USR PWD");
			return "password-reset";
		}
		
		System.out.println("RESET NO PWD");
		return "password-reset";
	}
}
