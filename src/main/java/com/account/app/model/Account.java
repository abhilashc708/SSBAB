package com.account.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long column_id;
	
	private String transactionType;
	
	private String useraccountno;
	
	private String sendaccountname;
	
	private String sendaccountno;
	
	private String recieveaccountname;
	
	private String recieveaccountno;
	
	private String amount;
	
	private String status;
	
	private Date date;

	public Long getColumn_id() {
		return column_id;
	}

	public void setColumn_id(Long column_id) {
		this.column_id = column_id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getUseraccountno() {
		return useraccountno;
	}

	public void setUseraccountno(String useraccountno) {
		this.useraccountno = useraccountno;
	}

	public String getSendaccountname() {
		return sendaccountname;
	}

	public void setSendaccountname(String sendaccountname) {
		this.sendaccountname = sendaccountname;
	}

	public String getSendaccountno() {
		return sendaccountno;
	}

	public void setSendaccountno(String sendaccountno) {
		this.sendaccountno = sendaccountno;
	}

	public String getRecieveaccountname() {
		return recieveaccountname;
	}

	public void setRecieveaccountname(String recieveaccountname) {
		this.recieveaccountname = recieveaccountname;
	}

	public String getRecieveaccountno() {
		return recieveaccountno;
	}

	public void setRecieveaccountno(String recieveaccountno) {
		this.recieveaccountno = recieveaccountno;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
