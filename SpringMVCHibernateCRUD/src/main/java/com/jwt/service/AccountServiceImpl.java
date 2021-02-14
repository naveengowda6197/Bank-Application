package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.AccountDAO;
import com.jwt.model.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	@Transactional
	public void addAccount(Account account) {
		accountDAO.addAccount(account);
	}

	@Override
	@Transactional
	public List<Account> getAllAccount() {
		return accountDAO.getAllAccount();
	}


	public Account getAccount(int ac_no) {
		return accountDAO.getAccount(ac_no);
	}

	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDAO.updateAccount(account);
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public boolean authenticateUserLogin(String email,String password ) {
		return accountDAO.authenticateUserLogin( email, password );
	}

	public List<Account> getUserByEmail(String email)
	 {
		return accountDAO.getUserByEmail(email);
	}


}
