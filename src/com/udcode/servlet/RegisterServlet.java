package com.udcode.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.udcode.dao.AccountDao;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("password_confirmation");
		
		if (!repassword.equals(password)) {
			throw new ServletException("repassword can't equals password");
		}
		
		AccountDao view = new AccountDao();
		try {
			view.register(email, repassword);
			response.sendRedirect("main/config.jsp");
		} catch (Exception e) {
			throw new ServletException("operate error:"+e.getMessage());
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		doPost(request, response);
	}
}
