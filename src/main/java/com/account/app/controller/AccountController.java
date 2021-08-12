package com.account.app.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.app.Dto.AccountDto;
import com.account.app.model.Account;
import com.account.app.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping(value="/api/transactions",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody @Valid AccountDto accountDto) {
		try {
			if(service.save(accountDto)) {		
				return ResponseEntity.ok("Transaction successfully completed.");	
			}
              else {
            	  return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Transaction Failed.");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	@GetMapping(value="/api/transactionsAll",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccounts() {
		return service.findAll();
	}
	
	
	@GetMapping(value="/api/transactionsAll/{date}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findTransactionByDate(@PathVariable(value = "date") Date date) {
		try {

			List<Account> trans = service.findByDate(date);
			return ResponseEntity.ok(trans);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@GetMapping(value="/api/transactionsAll/{accountno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findAmountByAccount(@PathVariable(value = "accountno") String accountno) {
		try {

			List<Account> amount = service.findAmount(accountno);
			return ResponseEntity.ok(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
