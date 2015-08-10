package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.entity.CashCredit;
import com.ps.entity.Loan;
import com.ps.entity.Overdraft;
import com.ps.service.CreditService;

@Controller
public class CreditController {

	@Autowired
	private CreditService creditService;

	@RequestMapping("/add-overdraft")
	public String getOverdraft(Model model) {

		model.addAttribute("overdraft", (Overdraft)creditService.getCredit("OVERDRAFT"));
		return "add-overdraft";
	}
	
	@RequestMapping(value = "/add-overdraft", method = RequestMethod.POST)
	public String postOverdraft(@ModelAttribute("overdraft") Overdraft credit,
			@RequestParam("clientId") int id,@RequestParam("ammountGranted") int amm) {

		credit.setPeriod(30);
		creditService.saveOverdraft(credit, id,amm);
		return "add-overdraft";
	}

	@RequestMapping("/add-cash-credit")
	public String getCashCredit(Model model) {

		model.addAttribute("cashCredit", (CashCredit)creditService.getCredit("CASHCREDIT"));
		return "add-cash-credit";
	}

	@RequestMapping(value = "/add-cash-credit", method = RequestMethod.POST)
	public String postCashCredit(@ModelAttribute("cashCredit") CashCredit credit,
			@RequestParam("clientId") int id) {

		credit.setPeriod(90);
		creditService.save(credit, id);
		
		return "add-cash-credit";
	}

	@RequestMapping("/add-loan")
	public String getLoan(Model model) {

		model.addAttribute("loan", (Loan)creditService.getCredit("LOAN"));
		return "add-loan";
	}
	
	@RequestMapping(value = "/add-loan", method = RequestMethod.POST)
	public String postLoan(@ModelAttribute("loan") Loan credit,
			@RequestParam("clientId") int id) {

		credit.setPeriod(350);
		creditService.save(credit, id);
		
		return "add-loan";
	}

	@RequestMapping("/view-all-credits")
	public String getViewAllCredits(Model model) {

		model.addAttribute("cashCredits", creditService.getCashCredits());
		model.addAttribute("loans", creditService.getLoans());
		model.addAttribute("overdrafts", creditService.getOverdrafts());
		return "view-all-credits";
	}
	
	@RequestMapping("/repay/{id}")
	public String getRepay(Model model,@PathVariable int id) {

		model.addAttribute("creditId", id);
		return "repay";
	}
	@RequestMapping(value = "/repay/{id}", method = RequestMethod.POST)
	public String postRepay(@PathVariable int id,@RequestParam("ammount")int amm) {

		creditService.repay(id, amm);
		return "redirect:/view-all-credits";
	}
}
