package com.udcode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.udcode.dao.AccountDao;
import com.udcode.entity.User;

public class AuthorizationFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		 HttpServletRequest httpRequest = (HttpServletRequest) request; 
		 HttpServletResponse httpResponse = (HttpServletResponse) response; 
		 httpRequest.getSession();
		 Cookie[] cookies = httpRequest.getCookies();
		 boolean isLegitimate = false;
		 if(cookies!=null){
			 
			 for(Cookie cookie:cookies){
				 if("uni_id".equals(cookie.getName())){
					 String value = cookie.getValue();
					 
					 String email = value.substring(0, value.indexOf(","));
					 String password = value.substring(value.indexOf(",")+1);
					 
					 Object o =httpRequest.getSession().getAttribute("user");
					 
					 AccountDao accountDao = new AccountDao();
					 User user = accountDao.getUserByEMail(email);
					 
					 if(user.getAccount().getPassword().equals(password)){
						 isLegitimate = true;
						 break;
					 }
				 }
			 }
			
		 }
		 
		 if(!isLegitimate){
			
			 httpResponse.sendRedirect("../index.html");
		 }
		
		 chain.doFilter(httpRequest,httpResponse);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
