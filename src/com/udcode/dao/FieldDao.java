package com.udcode.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udcode.connfactory.ConnFactory;
import com.udcode.entity.Field;

public class FieldDao {

	public void addField(Field field){
		Session session  = ConnFactory.getInstance().getSession();
		Transaction tran = session.beginTransaction();
		
		session.save(field);
		tran.commit();
	}
	
	public List<Field> getAllField(){
		Session session  = ConnFactory.getInstance().getSession();
		Query query = session.createQuery("from Field");
		return query.list();		
	}
	
	public Field getFieldById(int id){
		Session session  = ConnFactory.getInstance().getSession();
		Field field = (Field) session.get(Field.class, id);
		return field;
	}
}
