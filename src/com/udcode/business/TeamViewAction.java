package com.udcode.business;

import com.opensymphony.xwork2.ActionSupport;
import com.udcode.service.ServiceConstance;
import com.udcode.service.ServiceFactory;
import com.udcode.service.TeamService;

public class TeamViewAction extends ActionSupport {
	
    private String name;

	private Integer filedId;
	
	public void createTeam() throws Exception {
		TeamService service = ServiceFactory.getService(ServiceConstance.TEAM_SERVICE);
		Long accountId = getAccountId();
		service.addTeam(name, filedId, accountId);
	}

	private Long getAccountId() {
		//TODO userAccountManager should give the current account with one interface.
		return 1L;
	}

}
