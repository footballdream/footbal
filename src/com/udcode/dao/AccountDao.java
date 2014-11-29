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
		
		if(accounts.size()==1 && accounts.get(0).getEmail().equals(email)){
			return true;
		}
		
		return false;
	}
	
	public User getUserByEMail(String email){

		Session session = ConnFactory.getInstance().getSession();
		String hql = "from User as user where user.account.email=:email";
		Query query = session.createQuery(hql);
		query.setString("email", email);
		List<User> user =  query.list();
		
		if(user.size()==1){
			return user.get(0);
		}
		
		return null;
	}
	
	public User register(String email, String password) throws Exception{

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

		return user;
	}
}
