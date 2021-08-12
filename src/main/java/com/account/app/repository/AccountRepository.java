package com.account.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.account.app.model.Account;

public interface  AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByDate(Date date);
	
	@Query("select amount from Account where recieveaccountno = ?1")
	List<Account> findAmountByAccount(String Accountno);

}
