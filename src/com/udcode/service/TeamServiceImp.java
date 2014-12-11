package com.udcode.service;

import com.udcode.dao.AccountDao;
import com.udcode.dao.TeamDao;
import com.udcode.entity.Account;
import com.udcode.entity.Field;
import com.udcode.entity.Team;

public class TeamServiceImp implements TeamService {

	public void addTeam(String name, Integer filedId, Long accountId) {
		Team team = buildTeam(name);
		TeamDao tDao = new TeamDao();
		tDao.addTeam(team);
	}

	private Team buildTeam(String name) {
		Team team = new Team();
		AccountDao aDao = new AccountDao();
		Account account = new Account();
		Field homeField = new Field(); 
		team.setName(name);
		team.setAccount(account);
		team.setHomeField(homeField);
		return team;
	}

}
