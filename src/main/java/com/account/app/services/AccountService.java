package com.account.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.account.app.Dto.AccountDto;
import com.account.app.model.Account;
import com.account.app.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public boolean save(AccountDto accountDto) throws ParseException {
		boolean isSave = false;
		Account account= new Account();
		Date date=new SimpleDateFormat("dd-MM-yyyy").parse(accountDto.getDate()); 
		BeanUtils.copyProperties(accountDto, account);
		account.setDate(date);
		account.setStatus("SUCCESS");
		if (account != null) {
			accountRepository.save(account);
			isSave = true;
		}
		return isSave;
	}

	public List<Account> findAll() {
		return accountRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
	}
	

public List<Account> findByDate(Date date) {
	return accountRepository.findByDate(date);
}

public List<Account> findAmount(String accountno) {
	return accountRepository.findAmountByAccount(accountno);
}
	
}
