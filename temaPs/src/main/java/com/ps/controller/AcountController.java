package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.entity.Account;
import com.ps.entity.Customer;
import com.ps.entity.User;
import com.ps.service.AccountService;
import com.ps.service.CustomerService;

@Controller
public class AcountController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	// ////
	// CREATE
	@RequestMapping("/account-add")
	public String getAddUser(Model model) {

		int id = 0;
		model.addAttribute("account", new Account());

		System.out.println("HERE");
		return "account-add";
	}

	@RequestMapping(value = "/account-add", method = RequestMethod.POST)
	public String postAddUser(@ModelAttribute("account") Account account,
			@RequestParam("clientId") int id) {

		System.out.println(id);
		Customer c = customerService.findOne(id);
		account.setCustomer(c);
		List<Account> a = c.getAccounts();
		a.add(account);
		customerService.save(c);
		accountService.save(account);

		return "account-add";
	}

	// ////////////////////////////////////////////
	// READ
	@RequestMapping("/account-view")
	public String getSeeUsers(Model model) {

		model.addAttribute("acountList", accountService.findAll());

		return "account-view";
	}

	// ///////////////////////////////
	// DELETE
	@RequestMapping("/account-delete/{id}")
	public String getDeleteAccount(@PathVariable("id") int id) {

		accountService.delete(id);

		return "redirect:/account-view";
	}

	// /////////////
	// EDIT
	@RequestMapping(value = "/account-edit/{id}", method = RequestMethod.GET)
	public String getEditAcc(Model model, @PathVariable("id") int id) {

		model.addAttribute("account", accountService.findOne(id));
		System.out.println("edit GET");
		return "account-edit";
	}

	@RequestMapping(value = "/account-edit/{id}", method = RequestMethod.POST)
	public String postEditAcc(@ModelAttribute("account") Account acc) {

		accountService.save(acc);
		System.out.println("edited!");
		return "redirect:/account-view";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public String getTransferAcc() {

		return "transfer";
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String postTransferAcc(@RequestParam("from") int from,
			@RequestParam("to") int to, @RequestParam("ammount") int ammount) {

		accountService.transfer(from, to, ammount);
		
		return "redirect:/account-view";
	}

}
