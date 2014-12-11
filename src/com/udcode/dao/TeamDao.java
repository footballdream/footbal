package com.udcode.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udcode.connfactory.ConnFactory;
import com.udcode.entity.Match;
import com.udcode.entity.Team;
import com.udcode.entity.User;
/**
 * Team DAO to manage the team table.
 * @author jieyn
 *
 */
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
	
	public List<Team> getAllTeam() {
		Session session = ConnFactory.getInstance().getSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_team");
		Query query = session.createSQLQuery(sql.toString()).addEntity(Team.class);
		List<Team> list = query.list();
		return list;
	}
	
	public Team getTeam(User account) {
        Session session = ConnFactory.getInstance().getSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_team AS team");
		sql.append(" WHERE   team.user_id = ? ");
		Query query = session.createSQLQuery(sql.toString()).addEntity(Team.class);
		query.setLong(0, account.getId());
		List<Team> list = query.list();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
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
