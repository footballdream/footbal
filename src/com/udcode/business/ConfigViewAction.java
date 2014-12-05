package com.udcode.business;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ConfigViewAction extends ActionSupport{

	public String showConfigPage() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		Map request = (Map)ActionContext.getContext().get("request");
		String email = (String) request.get("email");
	
		return SUCCESS;
	}


}
