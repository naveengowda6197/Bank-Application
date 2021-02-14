package com.jwt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addAccount(Account account) {
		sessionFactory.getCurrentSession().saveOrUpdate(account);

	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {

		return sessionFactory.getCurrentSession().createQuery("from Account")
				.list();
	}


	public Account getAccount(int ac_no) {
		return (Account) sessionFactory.getCurrentSession().get(
				Account.class, ac_no);
	}

	@Override
	public Account updateAccount(Account account) {
		sessionFactory.getCurrentSession().update(account);
		return account;
	}
	
	
	@SuppressWarnings({ "null", "unchecked" })
	public boolean authenticateUserLogin(String email,String password ) {
		boolean status=false;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Account.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password));
		
		@SuppressWarnings("unchecked")
		List<Account> accountReceivableModelsList = criteria.list();
		tx.commit();
		session.flush();
		session.clear();
		session.close();
	if(!accountReceivableModelsList.isEmpty()){		
	status=true;
	}
		return status;
		
	
	}
	@Override
	public List<Account> getUserByEmail(String email) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Account.class)
				.add(Restrictions.eq("email", email));
		
		@SuppressWarnings("unchecked")
		List<Account> listOfAccounts = criteria.list();
		return listOfAccounts;

	}
}