package com.ty.mySpringBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.mySpringBank.model.Account;
import com.ty.mySpringBank.model.Transaction;
import com.ty.mySpringBank.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService service;
	
	@GetMapping("/index")
	public String index() {
		return"index";
	}
	
	@GetMapping("/create")
	public String showCreateAccount(Model model) {
		model.addAttribute("account", new Account());
		return "create-account";
	}
	
	@PostMapping("/create")
	public String createAccount(@ModelAttribute Account account) {
		service.createAccount(account);
		return"redirect:/accounts/index";
	}
	
	@GetMapping("/deposit")
	public String showDeposit() {
		return "deposit";
	}
	
	@PostMapping("/deposit")
	public String deposit(@RequestParam String accountNumber, @RequestParam double amount) {
		service.deposit(accountNumber, amount);
		return "redirect:/accounts/index";
	}
	
	@GetMapping("/withdraw")
	public String showWithdraw() {
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
		service.withdraw(accountNumber, amount);
		return "redirect:/accounts/index";
	}
	
	@GetMapping("/transaction")
	public String showTransactionForm() {
		return "transactionform";
	}
	
	@PostMapping("/transaction")
	public String transaction(Model model ,@RequestParam String accountNumber) {
		List<Transaction> transaction= service.getTransaction(accountNumber);
		model.addAttribute("transaction", transaction);
		return"transaction";
	}
	@GetMapping("/contact")
	public String contact() {
		return"contact";
	}
	@GetMapping("/about")
	public String about() {
		return"about";
	}
	@GetMapping("/service")
	public String service() {
		return"service";
	}

}
