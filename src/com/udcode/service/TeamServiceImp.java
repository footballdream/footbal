package com.udcode.service;

import com.udcode.contextservice.UserContextService;
import com.udcode.dao.TeamDao;
import com.udcode.entity.Field;
import com.udcode.entity.Team;
import com.udcode.entity.User;
import com.udcode.exception.ContextServiceException;

public class TeamServiceImp implements TeamService {

	public void addTeam(String name, Integer filedId, Long accountId) throws ContextServiceException {
		Team team = buildTeam(name);
		TeamDao tDao = new TeamDao();
		tDao.addTeam(team);
	}

	private Team buildTeam(String name) throws ContextServiceException {
		Team team = new Team();
		Field homeField = new Field(); 
		team.setName(name);
		team.setHomeField(homeField);
		User user = UserContextService.Factory.getUserContextService().getCurrentUserInSession();
		team.setUser(user);
		return team;
	}

}
