/**
 * 
 */
package com.accounts.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shar939
 *
 */
@Entity
@Table(name = "accounts_mgmt")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long accountId;

	private String firstName;
	private String lastName;
	private BigDecimal balance;
	private String address;
	private boolean accoundStatus;
	

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAccoundStatus() {
		return accoundStatus;
	}

	public void setAccoundStatus(boolean accoundStatus) {
		this.accoundStatus = accoundStatus;
	}

	public Account(long accountId, String firstName, String lastName, BigDecimal balance, String address,
			boolean accoundStatus) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.address = address;
		this.accoundStatus = accoundStatus;
	}

	public Account() {
		super();
	}

}
