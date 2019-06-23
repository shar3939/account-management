/**
 * 
 */
package com.accounts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accounts.model.Account;

/**
 * @author shar939
 *
 */
@Repository
public interface AccountsRepo extends JpaRepository<Account, Long> {
 
}
