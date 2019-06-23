/**
 * 
 */
package com.accounts.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shar939
 *
 */
@Entity
@Table(name = "transaction_mgmt")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long accountID;
	private BigDecimal depositAmount;
	private BigDecimal withdrawlAmount;
	private Date depositedDate;
	private Long depositedByID;
	private Date withdrawlDate;

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public BigDecimal getWithdrawlAmount() {
		return withdrawlAmount;
	}

	public void setWithdrawlAmount(BigDecimal withdrawlAmount) {
		this.withdrawlAmount = withdrawlAmount;
	}

	public Date getDepositedDate() {
		return depositedDate;
	}

	public void setDepositedDate(Date depositedDate) {
		this.depositedDate = depositedDate;
	}

	public Long getDepositedByID() {
		return depositedByID;
	}

	public void setDepositedByID(Long depositedByID) {
		this.depositedByID = depositedByID;
	}

	public Date getWithdrawlDate() {
		return withdrawlDate;
	}

	public void setWithdrawlDate(Date withdrawlDate) {
		this.withdrawlDate = withdrawlDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Transaction(Long accountID, BigDecimal depositAmount, BigDecimal withdrawlAmount, Date depositedDate,
			Long depositedByID, Date withdrawlDate) {
		super();
		this.accountID = accountID;
		this.depositAmount = depositAmount;
		this.withdrawlAmount = withdrawlAmount;
		this.depositedDate = depositedDate;
		this.depositedByID = depositedByID;
		this.withdrawlDate = withdrawlDate;
	}

	public Transaction() {
		super();
	}

}