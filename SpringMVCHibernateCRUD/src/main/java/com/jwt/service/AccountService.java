package com.jwt.service;

import java.util.List;

import com.jwt.model.Account;

public interface AccountService {
	
	public void addAccount(Account account);

	public List<Account> getAllAccount();

	public Account getAccount(int ac_no);

	public Account updateAccount(Account employee);
	
	public boolean authenticateUserLogin(String email,String password );
	
	public List<Account> getUserByEmail(String email);

}
