package com.udcode.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityTeamInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String username = (String)session.get("username");
		if (username != null){
			System.out.println("user already login!");
			return invocation.invoke();
		}
		System.out.println("Not Login!");
		ctx.put("tip", "Please login firstly");
		return Action.LOGIN;
	}

}
