package com.udcode.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udcode.connfactory.ConnFactory;
import com.udcode.entity.Match;
import com.udcode.entity.Team;

public class TeamDao {

	public void addTeam(Team team){

		Session session = ConnFactory.getInstance().getSession();
		
		Transaction tran = session.beginTransaction();
		session.save(team);
		tran.commit();
	}
	
	public Team getTeam(Integer id){
		Session session = ConnFactory.getInstance().getSession();
		Team team = (Team) session.get(Team.class, id);
		return team;
	}
	
	public List<Match> getAllMatchByTeamId(Integer id){
		Session session = ConnFactory.getInstance().getSession();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_match AS m,t_team team ");
		sql.append(" WHERE   team.id = ? ");
		sql.append(" AND (m.homeTeam_id = team.id OR m.awayTeam_id = team.id) ");
		
		Query query = session.createSQLQuery(sql.toString()).addEntity(Match.class);
		query.setInteger(0, id);
		List<Match> list = query.list();
		return list;
	}
}
