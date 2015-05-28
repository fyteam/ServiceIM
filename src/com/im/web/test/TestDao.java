package com.im.web.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void save() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("save method is run..");
		System.out.println("session :" + session.hashCode());
	}
}
