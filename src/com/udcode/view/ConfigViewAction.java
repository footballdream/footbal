package com.udcode.view;

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

	public String getTeamName() throws Exception{
		String parm1 = ServletActionContext.getRequest().getParameter("parm1");
		String parm2 = ServletActionContext.getRequest().getParameter("parm2");
		
		System.out.println(parm1+"/"+parm2);
		
		ServletActionContext.getResponse().getWriter().print("test");
		return null;
	}

}
