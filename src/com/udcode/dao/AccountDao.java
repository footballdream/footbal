package com.udcode.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udcode.connfactory.ConnFactory;
import com.udcode.entity.Account;
import com.udcode.entity.User;

public class AccountDao {

	public boolean login(String email, String password) throws Exception {
		Session session = ConnFactory.getInstance().getSession();
		
		String hql = "from Account as account where account.email=:email and account.password=:password";
		Query query = session.createQuery(hql);
		query.setString("email", email);
		query.setString("password", password);

		List<Account> accounts =  query.list();
		
		if(accounts.size()==1){
			return true;
		}
		
		return false;
	}
	
	public void register(String email, String password) throws Exception{

		Session session = ConnFactory.getInstance().getSession();

		Account account = new Account();
		account.setEmail(email);
		account.setPassword(password);

		
		User user = new User();
		user.setAccount(account);
		
		Transaction tran = session.beginTransaction();
		session.save(account);
		session.save(user);
		tran.commit();

	}
}
