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
import com.ps.entity.LinkedCustomer;
import com.ps.service.AccountService;
import com.ps.service.CustomerService;
import com.ps.service.LinkedAccountService;

@Controller
public class LinkedAccountController {

	@Autowired
	private LinkedAccountService linkedAccountService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@RequestMapping("/linked-account-add")
	public String getAddUser(Model model) {

		List<Customer> customers = customerService.getAll();

		model.addAttribute("customer", customers);
		model.addAttribute("account", new Account());
		System.out.println("Linked account add get-------");
		return "linked-account-add";
	}

	@RequestMapping(value = "/linked-account-add", method = RequestMethod.POST)
	public String postAddUser(@ModelAttribute("account") Account account,
			@RequestParam("clientId") int id, @RequestParam("link1") int link1,
			@RequestParam("link2") int link2, @RequestParam("link3") int link3,
			@RequestParam("link4") int link4,
			@RequestParam("transactionLimit") int transactionLimit,
			@RequestParam("operationLimit") int operationLimitLimit) {
		linkedAccountService.save(id, link1, link2, link3, link4,
				transactionLimit, operationLimitLimit, account);
		return "redirect:/linked-account-view";
	}

	// ////////////////////////////////////////////
	// READ
	@RequestMapping("/linked-account-view")
	public String getSeeUsers(Model model) {

		model.addAttribute("linkedAccounts", linkedAccountService.findAll());
		return "linked-account-view";
	}

	// ///////////////////////////////
	// DELETE
	@RequestMapping("/linked-account-delete/{id}")
	public String getDeleteAccount(@PathVariable("id") int id) {
		linkedAccountService.delete(id);
		return "redirect:/linked-account-view";
	}

	// /////////////
	// EDIT
	@RequestMapping(value = "/linked-account-edit/{id}", method = RequestMethod.GET)
	public String getEditAcc(Model model, @PathVariable int id) {
		model.addAttribute("linkedAccount", linkedAccountService.findOne(id));
		model.addAttribute("customer", linkedAccountService.findAllNonLinked());
		
		return "linked-account-edit";
	}

	@RequestMapping(value = "/linked-account-edit/{id}", method = RequestMethod.POST)
	public String postEditAcc(@ModelAttribute("linkedAccount") LinkedCustomer customer,@RequestParam("link1") int link1,@RequestParam("link2") int link2, @RequestParam("link3") int link3,
			@RequestParam("link4") int link4) {
		linkedAccountService.save(customer,link1,link2,link3,link4);
		System.out.println("edited!");
		return "redirect:/linked-account-view";
	}

	@RequestMapping(value = "/linked-account-transfer/{id}", method = RequestMethod.GET)
	public String gettransferAcc(Model model, @PathVariable int id) {
		
		model.addAttribute("accounts", accountService.findAll());
		
		return "linked-account-transfer";
	}

	@RequestMapping(value = "/linked-account-transfer/{id}", method = RequestMethod.POST)
	public String posttransferAcc(@PathVariable("id") int id1,
			@RequestParam("id2") int id2, @RequestParam("amount") int amount) {

		linkedAccountService.transfer(id1, id2, amount);
		return "redirect:/linked-account-view";
	}
}
