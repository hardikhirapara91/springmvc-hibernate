package com.hardik.springmvc.dao;

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
	 * Get DB Session
	 * 
	 * @return
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * Save
	 */
	public void persist(Object object) {
		getSession().persist(object);
	}

	/**
	 * Update
	 */
	public void update(Object object) {
		getSession().update(object);
	}

	/**
	 * Delete
	 */
	public void delete(Object object) {
		getSession().delete(object);
	}
}
