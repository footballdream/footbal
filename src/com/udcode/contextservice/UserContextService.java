package com.udcode.contextservice;

import com.udcode.context.impl.UserContextServiceImpl;
import com.udcode.entity.User;
import com.udcode.entity.manage.LoginState;
import com.udcode.exception.ContextServiceException;

public interface UserContextService {
	
	 public class Factory {
		private static UserContextService instance = new UserContextServiceImpl();

		public static UserContextService getUserContextService() {
			 return instance;
		}
		
	 }

	 public User getCurrentUserInSession() throws ContextServiceException;
	 
	 public void updateUserToSession(User user) throws ContextServiceException;
	 
	 public boolean isUserLogin(User user) throws ContextServiceException;
	 
	 public LoginState getUserLoginState(User user) throws ContextServiceException;
}
