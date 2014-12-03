package com.udcode.business;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.udcode.dao.AccountDao;
import com.udcode.entity.User;

public class AccountViewAction extends ActionSupport{

	private String email;
	
	private String password;
	
	private String password_confirmation;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_confirmation() {
		return password_confirmation;
	}

	public void setPassword_confirmation(String passwordConfirmation) {
		password_confirmation = passwordConfirmation;
	}

	public String register() throws Exception {

		AccountDao accountDao = new AccountDao();
		try {
			User user = accountDao.register(email, password);

			ActionContext actionContext = ActionContext.getContext();
			actionContext.getSession().put("user", user);
			
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	 
	public String login() throws Exception {

		AccountDao accountDao = new AccountDao();
		boolean flg = false;
		try {
			flg = accountDao.login(email, password);

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		if(flg){
			User user = accountDao.getUserByEMail(email);
			ActionContext actionContext = ActionContext.getContext();
			actionContext.getSession().put("user", user);
			return SUCCESS;
		}
		return ERROR;
	}
}
