package com.hardik.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Get Session Factory
	 * 
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Persist Object
	 */
	public void persist(Object object) {
		getSession().persist(object);
	}

	/**
	 * Update
	 * 
	 * @param object
	 */
	public void update(Object object) {
		getSession().update(object);
	}
}
