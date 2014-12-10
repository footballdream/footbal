package com.udcode.context.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.udcode.contextservice.UserContextService;
import com.udcode.entity.User;
import com.udcode.entity.manage.LoginState;
import com.udcode.exception.ContextServiceException;

public class UserContextServiceImpl implements UserContextService {

	public User getCurrentUserInSession() throws ContextServiceException {
		try {
			ActionContext actionContext = ActionContext.getContext();

			return (User) actionContext.getSession().get("user");
		} catch (Exception e) {
			throw new ContextServiceException(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public void updateUserToSession(User user) throws ContextServiceException {
		try {
			ActionContext actionContext = ActionContext.getContext();
			actionContext.getSession().put("user", user);

			if (actionContext.getApplication().get("onLineUser") == null) {
				Map<String, LoginState> map = new HashMap<String, LoginState>();
				actionContext.getApplication().put("onLineUser", map);
			}

			Map<String, LoginState> map = (Map<String, LoginState>) actionContext
					.getApplication().get("onLineUser");

			LoginState lo = map.get(user.getAccount().getEmail());

			if (lo != null) {
				lo.setLastLoginTime(Calendar.getInstance().getTimeInMillis());
				lo.setType(LoginState.Type.PC);
				// TODO 这里根据请求获取 请求发出于何种设备
				map.put(user.getAccount().getEmail(), lo);
			} else {
				lo = new LoginState(LoginState.Type.PC, Calendar
						.getInstance().getTimeInMillis());
				map.put(user.getAccount().getEmail(), lo);
			}

		} catch (Exception e) {
			throw new ContextServiceException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public boolean isUserLogin(User user) throws ContextServiceException {
		try {
			ActionContext actionContext = ActionContext.getContext();
			Map<String, LoginState> map = (Map<String, LoginState>) actionContext
					.getApplication().get("onLineUser");

			return map.get(user.getAccount().getEmail()) != null ? true : false;
		} catch (Exception e) {
			throw new ContextServiceException(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public LoginState getUserLoginState(User user)
			throws ContextServiceException {
		try {
			ActionContext actionContext = ActionContext.getContext();
			Map<String, LoginState> map = (Map<String, LoginState>) actionContext
					.getApplication().get("onLineUser");

			return map.get(user.getAccount().getEmail());
		} catch (Exception e) {
			throw new ContextServiceException(e.getMessage());
		}
	}

}
