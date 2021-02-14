package com.jwt.dao;

import java.util.List;
import com.jwt.model.Account;

public interface AccountDAO {

	public void addAccount(Account account);

	public List<Account> getAllAccount();

	
	public Account updateAccount(Account account);

	public Account getAccount(int ac_no);
	
	
	public boolean authenticateUserLogin(String email,String password );
	
	public List<Account> getUserByEmail(String email);
	
}
