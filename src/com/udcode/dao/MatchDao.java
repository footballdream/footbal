package com.udcode.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


import com.udcode.connfactory.ConnFactory;
import com.udcode.entity.Match;

public class MatchDao {

	public void addMatch(Match match){
		
		Session session = ConnFactory.getInstance().getSession();
		
		Transaction tran = session.beginTransaction();
		session.save(match);
		tran.commit();
	}
	
	public List<Match> getMatch(){
		Session session = ConnFactory.getInstance().getSession();
		Query query = session.createQuery("from Match");
		return query.list();		
	}
	
	public List<Match> getTeamMatchHistroy(int teamId){
		Session session = ConnFactory.getInstance().getSession();
		Query query = session.createQuery("from Match m where m.homeTeam.id=:id or m.awayTeam.id=:id");
		query.setParameter("id", teamId);
		return query.list();	
		
	}
}
