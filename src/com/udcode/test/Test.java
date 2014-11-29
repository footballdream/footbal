package com.udcode.test;

import java.util.List;

import com.udcode.dao.FieldDao;
import com.udcode.dao.MatchDao;
import com.udcode.dao.TeamDao;
import com.udcode.entity.Field;
import com.udcode.entity.Match;
import com.udcode.entity.Team;

public class Test {

	public static void main(String args[]) {
		testAddSomeMatchs();
	}
	
	public static void testAddSomeMatchs(){
		TeamDao tdao=new TeamDao();
		Team t1 = tdao.getTeam(1);
		Team t2 = tdao.getTeam(2);
		Team t9 = tdao.getTeam(9);
		Team t10 = tdao.getTeam(10);
		
		MatchDao dao = new MatchDao();
		
		//----------1
		// create match
		
		Match match = new Match();

		match.setDate("2014-5-3");
		match.setHomeScore(3);
		match.setAwayScore(2);

		match.setHomeTeam(t1);
		match.setAwayTeam(t10);

		dao.addMatch(match);
		
		//----------2
		// create match
		
		Match match2 = new Match();

		match2.setDate("2014-7-22");
		match2.setHomeScore(4);
		match2.setAwayScore(4);

		match.setHomeTeam(t1);
		match.setAwayTeam(t9);

		dao.addMatch(match2);
	}
	
	public static void testQueryAllMatch(){
		MatchDao m = new MatchDao();
		List<Match> list = m.getTeamMatchHistroy(10);
		
		for(Match match : list){
			System.out.println(match.getHomeTeam().getName());
		}
	}
	
	public static void testField2(){
		Field field =new Field();
		
		field.setName("南湖公园球场");
		field.setPrice(600);
		field.setPicture("2.jpg");
		field.setDesc("毗邻南湖公园");
		FieldDao fdao = new FieldDao();
		fdao.addField(field);
		
	}
	
	public static void testField(){
		Field field =new Field();
		
		field.setName("望京1号球场");
		field.setPrice(50);
		field.setPicture("1.jpg");
		field.setDesc("下机场辅路就是，离望京很近，价格便宜实惠");
		FieldDao fdao = new FieldDao();
		fdao.addField(field);
		
	}

	public static void testSave() {
		// create team

		Team home = new Team();
		home.setCreateTime("2010-2-2");
		home.setId(12);
		home.setName("红色攻势");

		Team away = new Team();
		away.setCreateTime("2012-2-2");
		away.setId(22);
		away.setName("爱立信");
		FieldDao fdao = new FieldDao();
		home.setHomeField(fdao.getFieldById(3));
		away.setHomeField(fdao.getFieldById(2));
		
		TeamDao tDao = new TeamDao();
		tDao.addTeam(home);
		tDao.addTeam(away);
		// create match
		MatchDao dao = new MatchDao();
		Match match = new Match();

		match.setDate("2014-8-13");
		match.setHomeScore(1);
		match.setAwayScore(2);

		match.setHomeTeam(home);
		match.setAwayTeam(away);

		dao.addMatch(match);
	
	}
}
