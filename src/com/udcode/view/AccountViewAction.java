package com.udcode.view;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.udcode.context.impl.UserContextServiceImpl;
import com.udcode.contextservice.UserContextService;
import com.udcode.dao.AccountDao;
import com.udcode.entity.User;

public class AccountViewAction extends ActionSupport {

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

			UserContextService userContextService = new UserContextServiceImpl();
			
			userContextService.updateUserToSession(user);

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

		if (flg) {

			User user = accountDao.getUserByEMail(email);
			String rememberCookie = ServletActionContext.getRequest()
					.getParameter("remember_cookie");
			if ("rememberme".equals(rememberCookie)) {
				setCookie(user);
			}

			UserContextService userContextService = new UserContextServiceImpl();
			
			userContextService.updateUserToSession(user);
			
			return SUCCESS;
		}
		return ERROR;
	}

	private void setCookie(User user) {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();

		if (needAddCookie(cookies)) {
			Cookie namecookie = new Cookie("uni_id", email + ","
					+ user.getAccount().getPassword());
			namecookie.setMaxAge(60 * 60 * 7);
			ServletActionContext.getResponse().addCookie(namecookie);
		}

	}

	private boolean needAddCookie(Cookie[] cookies) {

		if (cookies == null)
			return true;

		for (Cookie cookie : cookies) {
			if ("uni_id".equals(cookie.getName())) {
				return true;
			}
		}

		return false;
	}
}
