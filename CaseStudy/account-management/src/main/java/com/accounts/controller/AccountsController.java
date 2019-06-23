/**
 * 
 */
package com.accounts.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accounts.dao.AccountsRepo;
import com.accounts.dao.TransactionsRepo;
import com.accounts.model.Account;
import com.accounts.model.Transaction;

/**
 * @author shar939
 *
 */
@RestController
public class AccountsController {

	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	TransactionsRepo transactionsRepo;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping(path = "/accounts", produces = "application/json", consumes = "application/json")
	public String createAccount(@RequestBody Account account) {

		log.info("About to create Account");
		accountsRepo.save(account);
		log.info("Account has been created");

		return "Account Successfully Created";
	}

	/**
	 * 
	 * @param accountID
	 * @return Account
	 */
	@GetMapping(path = "/accounts/accountID/{accountID}")
	public Account getAccountDtls(@PathVariable(name = "accountID") Long accountID) {

		Account account = null;

		if (accountID != null && accountID != 0) {
			account = accountsRepo.getOne(accountID);
		}

		return account;
	}

	@Autowired
	private RestTemplate client;

	@CrossOrigin
	@SuppressWarnings("deprecation")
	@PostMapping(path = "/accounts/deposit", produces = "application/json", consumes = "application/json")
	public Account addBalance(@RequestBody Transaction transactionDtls) {
		Account accountDtls = null;
		if (transactionDtls != null) {
			Long accountID = transactionDtls.getAccountID();
			accountDtls = client.getForObject("http://localhost:8100/accounts/accountID/" + accountID, Account.class);
			if(accountDtls!=null) {
				BigDecimal prevAmnt = accountDtls.getBalance();
				BigDecimal finalBalance = prevAmnt.add(transactionDtls.getDepositAmount());
				accountDtls.setBalance(finalBalance);
				transactionDtls.setDepositedDate(new Date(getCurrentDateTime()));
				transactionsRepo.save(transactionDtls);
				accountsRepo.save(accountDtls);
			}
			log.info("Deposited Successfully ");
		}
		return accountDtls; 
	}
	
	private static String getCurrentDateTime() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}
