/**
 * 
 */
package com.accounts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accounts.model.Transaction;

/**
 * @author shar939
 *
 */
@Repository
public interface TransactionsRepo extends JpaRepository<Transaction, Long> {
	 
}
