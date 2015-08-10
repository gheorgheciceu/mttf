package com.ps.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.sdms.repository.CategoryRepository;





import com.ps.command.Payment;
import com.ps.command.PaymentPlan;
import com.ps.entity.Account;
import com.ps.entity.Admin;
import com.ps.entity.CashCredit;
import com.ps.entity.Credit;
import com.ps.entity.Customer;
import com.ps.entity.Loan;
import com.ps.entity.Operation;
import com.ps.entity.OperationType;
import com.ps.entity.Overdraft;
import com.ps.entity.Role;
import com.ps.entity.User;
import com.ps.factory.ExportFactory;
import com.ps.repository.AccountRepository;
import com.ps.repository.AdminRepository;
import com.ps.repository.CreditRepository;
import com.ps.repository.OperationRepository;
import com.ps.repository.OperationTypeRepository;
import com.ps.repository.RoleRepository;
import com.ps.repository.UserRepository;

@Transactional
@Service
public class DbService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerService cust;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private ExportFactory exporterFcatory;

	@Autowired
	private OperationService operationService;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private OperationTypeRepository operationTypeRepository;
	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private CreditService creditService;
	@PostConstruct
	public void init() {

		PaymentPlan.setPayments(new ArrayList<Payment>());
		
		Role rolAdmin = new Role();
		rolAdmin.setRoleName("ROLE_ADMIN");
		roleRepository.save(rolAdmin);
		Admin a = new Admin();
		a.setEmail("admin@ps.com");
		a.setPassword("admin");
		a.setRole(rolAdmin);
		a.setFirstName("Gheorghe");
		a.setLastName("Ciceu");

		List<Admin> admins = new ArrayList<Admin>();
		admins.add(a);
		rolAdmin.setAdminList(admins);
		roleRepository.save(rolAdmin);

		Role rolUser = new Role();
		rolUser.setRoleName("ROLE_USER");
		roleRepository.save(rolUser);

		User us = new User();
		us.setUsername("user@ps.com");
		us.setPassword("admin");
		us.setRole(rolUser);
		us.setFirstName("Gheorghe");
		us.setLastName("Ciceu");

		List<User> usr = new ArrayList<User>();
		usr.add(us);
		rolUser.setUserList(usr);
		roleRepository.save(rolUser);

		OperationType opt = new OperationType();
		opt.setMaximum(100);
		opt.setType("transfer");
		operationTypeRepository.save(opt);

		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setFirstName("John");
			u.setLastName("Doe" + i);
			u.setUsername("a@a.com");
			userRepository.save(u);
		}

		User u = new User();
		u.setFirstName("User1");
		u.setLastName("Some Name");
		u.setUsername("a@a.com");
		userRepository.save(u);

		for (int i = 0; i < 8; i++) {
			Customer c = new Customer();
			c.setFirstName("Customer" + i);
			c.setLastName("Customer");
			Account acc = new Account();
			acc.setCustomer(c);
			acc.setCreationDate(new Date());
			acc.setBalance(1500);
			acc.setType("spend");
			
			List<Account> accs = new ArrayList<Account>();
			accs.add(acc);
			c.setAccounts(accs);
			
			cust.save(c);
			accountRepository.save(acc);
			
		}

		

		for (int i = 0; i < 5; i++) {
			Operation o = new Operation();
			o.setAmount(i * 100);
			o.setDate(new Date());
			o.setDescription("descriere " + i);
			o.setInterestRate(100 + "//" + i);
			o.setOperationName("Transfer");
			o.setUser(u);

			operationRepository.save(o);
		}

	/*	Customer custo  = new Customer();
		custo.setFirstName("Emil");
		custo.setLastName("Danea");
		cust.save(custo);
		for(int i=0;i<=3;i++){
			Credit c = new Loan();
			c.setCustomer(custo);
			c.setCreationDate(new Date());
			c.setLimit(3444+i*453);
			creditRepository.save(c);
		}
		
		for(int i=0;i<=3;i++){
			Credit c = new Overdraft();
			c.setCustomer(custo);
			c.setCreationDate(new Date());
			c.setLimit(3444+i*453);
			creditRepository.save(c);
		}
		
		for(int i=0;i<=3;i++){
			Credit c = new CashCredit();
			c.setCustomer(custo);
			c.setCreationDate(new Date());
			c.setLimit(3444+i*453);
			creditRepository.save(c);
		}*/
		
	}
	

}
