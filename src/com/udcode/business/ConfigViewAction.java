package com.udcode.business;

import java.util.Map;

import javax.servlet.http.Cookie;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ConfigViewAction extends ActionSupport{

	public String showConfigPage() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		Map request = (Map)ActionContext.getContext().get("request");
		String email = (String) request.get("email");
		String password = (String) request.get("password");
		Cookie namecookie = new Cookie("email",email);     
		Cookie passwordcookie = new Cookie("password",password);     
		Cookie optioncookie = new Cookie("option","1"); 
		
		return SUCCESS;
	}
}
